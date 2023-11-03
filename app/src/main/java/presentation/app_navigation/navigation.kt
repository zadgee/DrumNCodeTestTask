package presentation.app_navigation
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import domain.entities.PhotoDetailsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.detailsScreen.DetailsScreen
import presentation.detailsScreen.state.EmptyOrNullChecking
import presentation.detailsScreen.viewModel.DetailsViewModel
import presentation.detailsScreen.viewModel.PhotoPositionViewModelFactory
import presentation.detailsScreen.viewModel.PhotoPositionsViewModel
import presentation.mainScreen.MainScreen
import presentation.mainScreen.PhotosListViewModel
import presentation.splashscreen.LoadingScreen



@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val changingScope = CoroutineScope(Dispatchers.Main)
    val photosListViewModel = hiltViewModel<PhotosListViewModel>()
    val detailsViewModel = hiltViewModel<DetailsViewModel>()

        NavHost(
            navController = navController, startDestination = Routes.LoadingScreen.route
        ){

        composable(Routes.LoadingScreen.route){
           LoadingScreen()
           LaunchedEffect(key1 = Unit){
               delay(100)
               navController.navigate(Routes.MainScreen.route)
           }

        }

        composable(Routes.MainScreen.route){
            val recentPhotosState = photosListViewModel.recentPhotosState
                .collectAsState()
            val photoList = recentPhotosState.value.success?.body()?.photos ?:
            EmptyOrNullChecking.recentPhotoIdModel()


            LaunchedEffect(
                key1 = recentPhotosState.value.error
            ){
                if(recentPhotosState.value.error != null){
                    Log.d("TAG", "Error occurred here:${
                        recentPhotosState.value.error
                    }")
                }
            }


            MainScreen(
                onImageClick = { serverId, photoId, secret ->
                    changingScope.launch {
                            val response = detailsViewModel.getPhotosDetailsFromInternet(
                                photoId
                            )
                            delay(10)
                            detailsViewModel.savePhotoDetails(
                                PhotoDetailsEntity(
                                    retrievedPhotoId = photoId,
                                    photoDetails = response.body()?.photo
                                )
                            )
                        delay(10)
                        navController.navigate(
                            "details_screen/$serverId/$photoId/$secret"
                        )
                    }
                },
                viewModel = photosListViewModel,
                idList = photoList,

            )
        }

        composable(Routes.DetailsScreen.route){
            val serverId = it.arguments?.getString("serverId") ?: ""
            val defaultSecret = it.arguments?.getString("secret") ?:""
            val defaultPhotoId = it.arguments?.getString("photoId") ?: ""
            val getPhotosListFromDB = photosListViewModel.gettingPhotosListFromDatabaseState
                .collectAsState().value
            val photoDetailsFromDataBaseState = detailsViewModel.
            gettingPhotoDetailsFromDatabaseState
                .collectAsState()

            val photoPositionsViewModel = viewModel<PhotoPositionsViewModel>(
                factory = PhotoPositionViewModelFactory(
                    defaultPhotoId = defaultPhotoId,
                    serverId = serverId,
                    recentPhotoIdModel = getPhotosListFromDB?.recentPhotoIdModel,
                    secret = defaultSecret
                )
            )

            val photoPositionState = photoPositionsViewModel.
            imagePositionState.collectAsState().value

            val imageLink = photoPositionsViewModel.imageLinkState.collectAsState().value

            val title = photoDetailsFromDataBaseState.value?.photoDetails?.titleModel?.title?:""
            val realName = photoDetailsFromDataBaseState.value?.photoDetails?.ownerModel?.
                    realName?:""
            val userName = photoDetailsFromDataBaseState.value?.photoDetails?.ownerModel?.
                    username?:""


                DetailsScreen(
                    goBackToMainScreen = {
                        changingScope.launch {
                            photoDetailsFromDataBaseState.value?.let {
                             details->
                                detailsViewModel.deletePhotoDetailsFromDataBase(
                                    details
                                )
                            }
                            delay(10)
                            getPhotosListFromDB?.let {
                                photos ->
                                photosListViewModel.updatePhotoListEntity(
                                    photos
                                )
                            }
                            delay(10)
                            navController.popBackStack()
                        }
                    },
                    detailsViewModel = detailsViewModel,
                    photosListViewModel = photosListViewModel,
                    defaultChosenPhotoId = defaultPhotoId,
                    photoPositionsViewModel = photoPositionsViewModel,
                    imageLink = imageLink,
                    realName = realName,
                    title = title,
                    userName = userName
                )
        }
    }
}