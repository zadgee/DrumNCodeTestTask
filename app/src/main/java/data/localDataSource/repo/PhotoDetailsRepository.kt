package data.localDataSource.repo
import data.localDataSource.model.PhotoDetailsEntity

interface PhotoDetailsRepository{
    suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity)
    suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?)
    suspend fun getPhotoDetails(photoId:String): PhotoDetailsEntity
    suspend fun updatePhotoDetails(photoDetails:PhotoDetailsEntity)
}