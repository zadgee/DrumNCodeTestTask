package data.localDataSource.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import domain.entities.RecentPhotoBasicInfoEntity

@Dao
interface RecentPhotosDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)

    @Query("SELECT * FROM RECENT_PHOTOS_INFO")
    suspend fun getAllPhotos(): RecentPhotoBasicInfoEntity


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateListWithPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)

    @Delete
    suspend fun deleteAllPhotos(recentPhotoBasicInfoEntity: RecentPhotoBasicInfoEntity)

}