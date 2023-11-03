package domain.usecases
import data.localDataSource.model.PhotoDetailsEntity
import data.localDataSource.repo.PhotoDetailsRepository
import javax.inject.Inject

class UpdatePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun updatePhotoDetails(photoDetails: PhotoDetailsEntity){
       return repository.updatePhotoDetails(photoDetails)
    }

}