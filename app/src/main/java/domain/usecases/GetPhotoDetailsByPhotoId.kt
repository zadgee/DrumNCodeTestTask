package domain.usecases
import domain.entities.PhotoDetailsEntity
import domain.repository.PhotoDetailsRepository
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