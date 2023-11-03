package domain.usecases

import domain.entities.RecentPhotoBasicInfoEntity
import domain.repository.RecentPhotoRepository
import javax.inject.Inject

class SavePhotoListFromInternetToDBUseCase @Inject constructor(
    private val repository: RecentPhotoRepository
) {

    suspend fun saveListWithPhotos(photos: RecentPhotoBasicInfoEntity){
        return repository.saveListWithPhotos(photos)
    }

}