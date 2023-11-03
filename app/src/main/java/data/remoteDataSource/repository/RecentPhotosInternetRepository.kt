package data.remoteDataSource.repository
import data.event.RetrieveRecentPhotosInfoEvent
import data.remoteDataSource.model.DetailedPhotoInfo
import retrofit2.Response


interface RecentPhotosInternetRepository{
    suspend fun getAllPhotosFromInternet(): RetrieveRecentPhotosInfoEvent
    suspend fun getPhotoDetailsFromInternet(photoId:String?): Response<DetailedPhotoInfo>
}