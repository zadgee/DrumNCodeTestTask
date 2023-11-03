package data.remoteDataSource.repositoryImpl
import data.event.RetrieveRecentPhotosInfoEvent
import data.remoteDataSource.api.FlickrAPI
import domain.entities.DetailedPhotoInfo
import domain.repository.RecentPhotosInternetRepository
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