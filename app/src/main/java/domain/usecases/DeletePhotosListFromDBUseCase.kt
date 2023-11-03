package domain.usecases

import data.localDataSource.model.RecentPhotoBasicInfoEntity
import data.localDataSource.repo.RecentPhotoRepository
import javax.inject.Inject

class DeletePhotosListFromDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun deleteAllPhotos(photos: RecentPhotoBasicInfoEntity){
        repository.deleteAllPhotos(photos)
    }

}