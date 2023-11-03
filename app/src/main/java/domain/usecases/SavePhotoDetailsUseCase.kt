package domain.usecases
import data.localDataSource.model.PhotoDetailsEntity
import data.localDataSource.repo.PhotoDetailsRepository
import javax.inject.Inject

class SavePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity){
        return repository.savePhotoDetails(photoDetails)
    }

}