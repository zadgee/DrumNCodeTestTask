package presentation.mainScreen
import androidx.compose.runtime.Composable
import data.remoteDataSource.model.RecentPhotoIdModel

@Composable
fun MainScreen(
    onImageClick:(serverId:String,photoId:String,secret:String)->Unit,
    viewModel:PhotosListViewModel,
    idList: RecentPhotoIdModel,
){



   MainScreenContent(
       photosListViewModel = viewModel,
       onImageClick = onImageClick,
       idList = idList,
   )
}