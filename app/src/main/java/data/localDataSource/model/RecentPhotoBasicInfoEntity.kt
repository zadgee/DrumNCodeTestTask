package data.localDataSource.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import data.remoteDataSource.model.RecentPhotoIdModel


@Entity(
     tableName = "RECENT_PHOTOS_INFO"
    )
data class RecentPhotoBasicInfoEntity(
      @PrimaryKey(autoGenerate = false)
      val recentPhotoIdModel:RecentPhotoIdModel
)
