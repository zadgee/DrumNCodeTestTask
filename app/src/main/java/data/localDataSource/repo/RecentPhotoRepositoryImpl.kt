package data.localDataSource.repo
import android.util.Log
import data.localDataSource.dao.RecentPhotosDAO
import data.localDataSource.model.RecentPhotoBasicInfoEntity
import javax.inject.Inject

class RecentPhotoRepositoryImpl @Inject constructor(
    private val dao: RecentPhotosDAO
): RecentPhotoRepository {
    override suspend fun saveListWithPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity) {
        try {
            dao.savePhotos(recentPhotoBasicInfoEntity)
        }catch (e:Exception){
            e.printStackTrace()
            Log.d("DB_TAG","Saving list with photos error :${e.message}")
        }
    }

    override suspend fun getAllPhotos(): RecentPhotoBasicInfoEntity {
       return dao.getAllPhotos()
    }

    override suspend fun deleteAllPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity) {
        try {
            dao.deleteAllPhotos(recentPhotoBasicInfoEntity)
        }catch (e:Exception){
            e.printStackTrace()
            Log.d("DB_TAG","Deleting list with photos error :${e.message}")
        }
    }

    override suspend fun updateListWithPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity) {
        try {
            dao.updateListWithPhotos(recentPhotoBasicInfoEntity)
        }catch (e:Exception){
            e.printStackTrace()
            Log.d("DB_TAG","Updating list with photos error :${e.message}")
        }
    }


}