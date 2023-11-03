package data.event

import data.remoteDataSource.model.RecentPhotoIdListModel
import retrofit2.Response

sealed class RetrieveRecentPhotosInfoEvent{
    data class Success(val data:Response<RecentPhotoIdListModel>): RetrieveRecentPhotosInfoEvent()
    data class Error(val message:String): RetrieveRecentPhotosInfoEvent()
}
