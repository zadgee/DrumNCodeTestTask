package presentation.detailsScreen
import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import domain.entities.PhotoDetailsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.detailsScreen.state.EmptyOrNullChecking
import presentation.detailsScreen.viewModel.DetailsViewModel
import presentation.detailsScreen.viewModel.PhotoPositionsViewModel
import presentation.mainScreen.PhotosListViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetailsScreen(
    goBackToMainScreen:()->Unit,
    detailsViewModel: DetailsViewModel,
    defaultChosenPhotoId:String,
    photosListViewModel: PhotosListViewModel,
    photoPositionsViewModel: PhotoPositionsViewModel,
    imageLink:String,
    realName:String,
    title:String,
    userName:String
){
    val changingScope = CoroutineScope(Dispatchers.Unconfined)

    LaunchedEffect(key1 = Unit){
        detailsViewModel.getPhotoDetailsByPhotoId(
            defaultChosenPhotoId
        )
    }
    var imagePositionState = photoPositionsViewModel.imagePositionState.collectAsState().value

    BackHandler(
        onBack = goBackToMainScreen
    )

            DetailsScreenContent(
                goBackToMainScreen = goBackToMainScreen,
                realName = EmptyOrNullChecking.realName(
                    realName = realName
                ),
                imageLink = imageLink,
                title = EmptyOrNullChecking.title(
                    title
                ),
                userName = EmptyOrNullChecking.userName(
                    userName
                ),
                onPreviousClick = {
                    changingScope.launch {
                        photosListViewModel.getPhotoListFromDB()
                        delay(5)
                        imagePositionState--
                        val previousPhotoId = photoPositionsViewModel.photoPositionPrevious() ?:""
                        val response = detailsViewModel.getPhotosDetailsFromInternet(
                            previousPhotoId
                        )
                        delay(5)
                        detailsViewModel.updatePhotoDetails(
                            PhotoDetailsEntity(
                                photoDetails = response.body()?.photo,
                                retrievedPhotoId = previousPhotoId
                            )
                        )
                        
                    }
                },
                onNextClick = {
                    changingScope.launch {
                        photosListViewModel.getPhotoListFromDB()
                        delay(5)
                        imagePositionState++
                        val newPhotoId = photoPositionsViewModel.photoPositionNext() ?:""
                        delay(5)
                        val response = detailsViewModel.getPhotosDetailsFromInternet(
                            newPhotoId
                        )
                        detailsViewModel.updatePhotoDetails(
                            PhotoDetailsEntity(
                                photoDetails = response.body()?.photo,
                                retrievedPhotoId = newPhotoId
                            )
                        )
                    }
                }
            )

    BackHandler(onBack = goBackToMainScreen)
}