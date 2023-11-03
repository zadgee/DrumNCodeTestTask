package domain.entities
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.entities.DetailedPhotoInfoModel

@Entity(
    tableName = "PHOTO_DETAILS_TABLE",
    )
data class PhotoDetailsEntity(
    @PrimaryKey(autoGenerate = false)
    val retrievedPhotoId:String,
    val photoDetails: DetailedPhotoInfoModel?,
)
