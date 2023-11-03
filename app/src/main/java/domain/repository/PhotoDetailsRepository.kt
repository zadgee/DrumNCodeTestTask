package domain.repository
import domain.entities.PhotoDetailsEntity

interface PhotoDetailsRepository{
    suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity)
    suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?)
    suspend fun getPhotoDetails(photoId:String): PhotoDetailsEntity
    suspend fun updatePhotoDetails(photoDetails: PhotoDetailsEntity)
}