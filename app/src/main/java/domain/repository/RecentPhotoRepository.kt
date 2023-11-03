package domain.repository
import domain.entities.RecentPhotoBasicInfoEntity

interface RecentPhotoRepository{
    suspend fun saveListWithPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)
    suspend fun getAllPhotos(): RecentPhotoBasicInfoEntity
    suspend fun deleteAllPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)
    suspend fun updateListWithPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)
}