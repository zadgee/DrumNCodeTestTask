package data.localDataSource.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import data.remoteDataSource.model.DetailedPhotoInfoModel

@Entity(
    tableName = "PHOTO_DETAILS_TABLE",
    )
data class PhotoDetailsEntity(
    @PrimaryKey(autoGenerate = false)
    val retrievedPhotoId:String,
    val photoDetails: DetailedPhotoInfoModel?,
)
