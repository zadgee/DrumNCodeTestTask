package domain.usecases
import data.event.GetPhotoDetailsFromDBEvent
import data.localDataSource.model.PhotoDetailsEntity
import data.localDataSource.repo.PhotoDetailsRepository
import javax.inject.Inject

class GetPhotoDetailsByPhotoId @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun getDetails(
        photoId:String
    ): PhotoDetailsEntity {
        return repository.getPhotoDetails(photoId)
    }

}