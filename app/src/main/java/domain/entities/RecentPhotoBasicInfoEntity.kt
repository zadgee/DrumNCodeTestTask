package domain.entities
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.entities.RecentPhotoIdModel


@Entity(
     tableName = "RECENT_PHOTOS_INFO"
    )
data class RecentPhotoBasicInfoEntity(
      @PrimaryKey(autoGenerate = false)
      val recentPhotoIdModel: RecentPhotoIdModel
)
