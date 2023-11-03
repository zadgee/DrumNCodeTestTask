package domain.usecases
import domain.entities.PhotoDetailsEntity
import domain.repository.PhotoDetailsRepository
import javax.inject.Inject

class SavePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity){
        return repository.savePhotoDetails(photoDetails)
    }

}