package domain.usecases

import data.localDataSource.model.PhotoDetailsEntity
import data.localDataSource.repo.PhotoDetailsRepository
import javax.inject.Inject

class DeletePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?){
        return repository.deletePhotoDetails(photoDetails)
    }

}