package data.remoteDataSource.repository
import data.event.RetrieveRecentPhotosInfoEvent
import data.remoteDataSource.api.FlickrAPI
import data.remoteDataSource.model.DetailedPhotoInfo
import retrofit2.Response
import javax.inject.Inject

class RecentPhotosInternetRepositoryImpl@Inject constructor(
    private val api: FlickrAPI
): RecentPhotosInternetRepository {

    override suspend fun getAllPhotosFromInternet(): RetrieveRecentPhotosInfoEvent {
        return try {
            RetrieveRecentPhotosInfoEvent.Success(
                api.getPhotosInfo()
            )
        } catch (e: Exception) {
            RetrieveRecentPhotosInfoEvent.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun getPhotoDetailsFromInternet(photoId: String?):Response<DetailedPhotoInfo>{
       return api.getPhotoDetails(photoId)
    }

}