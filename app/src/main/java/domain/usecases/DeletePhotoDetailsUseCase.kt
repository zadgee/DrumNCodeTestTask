package domain.usecases

import domain.entities.PhotoDetailsEntity
import domain.repository.PhotoDetailsRepository
import javax.inject.Inject

class DeletePhotoDetailsUseCase @Inject constructor(
    private val repository: PhotoDetailsRepository
) {

    suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?){
        return repository.deletePhotoDetails(photoDetails)
    }

}