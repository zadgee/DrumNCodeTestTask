package domain.repository
import data.event.RetrieveRecentPhotosInfoEvent
import domain.entities.DetailedPhotoInfo
import retrofit2.Response


interface RecentPhotosInternetRepository{
    suspend fun getAllPhotosFromInternet(): RetrieveRecentPhotosInfoEvent
    suspend fun getPhotoDetailsFromInternet(photoId:String?): Response<DetailedPhotoInfo>
}