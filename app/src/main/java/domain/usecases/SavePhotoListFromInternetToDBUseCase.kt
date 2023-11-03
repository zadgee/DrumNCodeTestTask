package domain.usecases

import data.localDataSource.model.RecentPhotoBasicInfoEntity
import data.localDataSource.repo.RecentPhotoRepository
import javax.inject.Inject

class SavePhotoListFromInternetToDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun saveListWithPhotos(photos:RecentPhotoBasicInfoEntity){
        return repository.saveListWithPhotos(photos)
    }

}