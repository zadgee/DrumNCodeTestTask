package domain.usecases
import data.remoteDataSource.model.DetailedPhotoInfo
import data.remoteDataSource.repository.RecentPhotosInternetRepository
import retrofit2.Response
import javax.inject.Inject

class RetrievePhotoDetailsFromNetwork@Inject constructor(
    private val repository: RecentPhotosInternetRepository
) {

    suspend fun getDetails(photoId: String?): Response<DetailedPhotoInfo> {
        return repository.getPhotoDetailsFromInternet(photoId)
    }
}