package domain.usecases

import data.localDataSource.model.RecentPhotoBasicInfoEntity
import data.localDataSource.repo.RecentPhotoRepository
import javax.inject.Inject

class UpdateListWithPhotosUseCase @Inject constructor(
    private val recentPhotosRepository: RecentPhotoRepository
) {

    suspend fun updateListWithPhotos(photos: RecentPhotoBasicInfoEntity){
        return recentPhotosRepository.updateListWithPhotos(photos)
    }

}