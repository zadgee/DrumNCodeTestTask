package domain.usecases

import domain.entities.RecentPhotoBasicInfoEntity
import domain.repository.RecentPhotoRepository
import javax.inject.Inject

class GetAllPhotosFromDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun getAllPhotos(): RecentPhotoBasicInfoEntity {
        return repository.getAllPhotos()
    }

}