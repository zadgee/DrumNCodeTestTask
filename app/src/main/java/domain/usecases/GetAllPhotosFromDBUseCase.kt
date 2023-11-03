package domain.usecases

import data.localDataSource.model.RecentPhotoBasicInfoEntity
import data.localDataSource.repo.RecentPhotoRepository
import javax.inject.Inject

class GetAllPhotosFromDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun getAllPhotos(): RecentPhotoBasicInfoEntity{
        return repository.getAllPhotos()
    }

}