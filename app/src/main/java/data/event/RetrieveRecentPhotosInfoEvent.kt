package data.event

import domain.entities.RecentPhotoIdListModel
import retrofit2.Response

sealed class RetrieveRecentPhotosInfoEvent{
    data class Success(val data:Response<RecentPhotoIdListModel>): RetrieveRecentPhotosInfoEvent()
    data class Error(val message:String): RetrieveRecentPhotosInfoEvent()
}
