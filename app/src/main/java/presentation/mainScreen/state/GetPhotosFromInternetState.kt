package presentation.mainScreen.state

import domain.entities.RecentPhotoIdListModel
import retrofit2.Response

data class GetPhotosFromInternetState(
    val success: Response<RecentPhotoIdListModel>? = null,
    val error:String? = null
)
