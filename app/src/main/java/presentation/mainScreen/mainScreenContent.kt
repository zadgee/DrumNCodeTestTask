package presentation.mainScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import data.localDataSource.model.RecentPhotoBasicInfoEntity
import data.remoteDataSource.model.RecentPhotoIdModel
import domain.usecases.DownLoadPhotoFromInternetUseCase
import kotlinx.coroutines.delay
import presentation.mainScreen.components.MainScreenCardModel


@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    idList: RecentPhotoIdModel,
    photosListViewModel: PhotosListViewModel,
    onImageClick:(serverId:String,photoId:String,secret:String)-> Unit,
){

    LaunchedEffect(key1 = Unit){
        photosListViewModel.getAllPhotos()
        delay(10)
            photosListViewModel.saveListWithPhotos(
               photos = RecentPhotoBasicInfoEntity(
                   recentPhotoIdModel = idList,
               )
            )
        delay(10)
        photosListViewModel.getPhotoListFromDB()
    }



      LazyVerticalGrid(
          columns = GridCells.Fixed(3),
          modifier = modifier.fillMaxSize(),
          horizontalArrangement = Arrangement.Center,
          verticalArrangement = Arrangement.Center,
      ){
          items(idList.photo.size){ index->
              val serverId = idList.photo[index].serverId
              val photoId = idList.photo[index].photoId
              val secret =  idList.photo[index].secret

              val imageLink = DownLoadPhotoFromInternetUseCase.downloadPhotoFromInternet(
                      serverId = serverId,
                      photoId = photoId,
                      secret = secret
              )


              MainScreenCardModel(
                  imageLink = imageLink,
                  onImageClick = onImageClick,
                  idList = idList.photo[index],
              )
          }
      }



}