package presentation.mainScreen.state

import data.remoteDataSource.model.RecentPhotoIdListModel
import retrofit2.Response

data class GetPhotosFromInternetState(
    val success: Response<RecentPhotoIdListModel>? = null,
    val error:String? = null
)
