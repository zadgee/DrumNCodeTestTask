package domain.usecases
import domain.entities.DetailedPhotoInfo
import domain.repository.RecentPhotosInternetRepository
import retrofit2.Response
import javax.inject.Inject

class RetrievePhotoDetailsFromNetwork@Inject constructor(
    private val repository: RecentPhotosInternetRepository
) {

    suspend fun getDetails(photoId: String?): Response<DetailedPhotoInfo> {
        return repository.getPhotoDetailsFromInternet(photoId)
    }
}