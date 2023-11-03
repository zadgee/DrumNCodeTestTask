package domain.usecases

import domain.entities.RecentPhotoBasicInfoEntity
import domain.repository.RecentPhotoRepository
import javax.inject.Inject

class UpdateListWithPhotosUseCase @Inject constructor(
    private val recentPhotosRepository: RecentPhotoRepository
) {

    suspend fun updateListWithPhotos(photos: RecentPhotoBasicInfoEntity){
        return recentPhotosRepository.updateListWithPhotos(photos)
    }

}