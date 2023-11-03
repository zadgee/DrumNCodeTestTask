package data.localDataSource.repo
import android.util.Log
import data.localDataSource.dao.PhotoDetailsDAO
import data.localDataSource.model.PhotoDetailsEntity
import javax.inject.Inject

class PhotoDetailsRepositoryImpl@Inject constructor(
    private val dao: PhotoDetailsDAO
) : PhotoDetailsRepository {


    override suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity){
         try {
            dao.savePhotoDetails(photoDetails)
        }catch (e:Exception){
           Log.d("DB_TAG",e.message ?:"Unknown error")
        }
    }

    override suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?) {
        try {
            dao.deletePhotoDetails(photoDetails)
        }catch (e:Exception){
            Log.d("TAG","Error while deleting photo details occurred here:${e.message}")
        }
    }

    override suspend fun getPhotoDetails(photoId:String): PhotoDetailsEntity {
        return dao.getPhotoDetails(photoId)
    }

    override suspend fun updatePhotoDetails(photoDetails: PhotoDetailsEntity){
        return dao.updatePhotoDetails(photoDetails)
    }

}