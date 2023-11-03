package data.localDataSource.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import domain.entities.PhotoDetailsEntity


@Dao
interface PhotoDetailsDAO {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun savePhotoDetails(photoDetails: PhotoDetailsEntity)

     @Update(onConflict = OnConflictStrategy.REPLACE)
     suspend fun updatePhotoDetails(photoDetails: PhotoDetailsEntity)

     @Query(
        "SELECT * FROM PHOTO_DETAILS_TABLE WHERE retrievedPhotoId = :photoId"
     )
     suspend fun getPhotoDetails(
          photoId:String
     ): PhotoDetailsEntity

     @Delete
     suspend fun deletePhotoDetails(photoDetails: PhotoDetailsEntity?)


}