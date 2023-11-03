package domain.usecases

import domain.entities.RecentPhotoBasicInfoEntity
import domain.repository.RecentPhotoRepository
import javax.inject.Inject

class DeletePhotosListFromDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun deleteAllPhotos(photos: RecentPhotoBasicInfoEntity){
        repository.deleteAllPhotos(photos)
    }

}