package domain.usecases
import domain.entities.PhotoDetailsEntity
import domain.repository.PhotoDetailsRepository
import javax.inject.Inject

class UpdatePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun updatePhotoDetails(photoDetails: PhotoDetailsEntity){
       return repository.updatePhotoDetails(photoDetails)
    }

}