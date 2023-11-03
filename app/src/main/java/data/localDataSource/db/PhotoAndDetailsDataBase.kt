package data.localDataSource.db
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import data.localDataSource.converters.DetailedPhotoInfoModelConverter
import data.localDataSource.converters.RecentPhotoIdModelConverter
import data.localDataSource.dao.PhotoDetailsDAO
import data.localDataSource.dao.RecentPhotosDAO
import domain.entities.PhotoDetailsEntity
import domain.entities.RecentPhotoBasicInfoEntity

@Database(entities = [
    RecentPhotoBasicInfoEntity::class, PhotoDetailsEntity::class
                     ], version = 3243, exportSchema = false
    )
@TypeConverters(
    RecentPhotoIdModelConverter::class,
    DetailedPhotoInfoModelConverter::class
)
abstract class PhotoAndDetailsDataBase: RoomDatabase() {
    abstract fun photoDetailsDao(): PhotoDetailsDAO
    abstract fun recentPhotosDao(): RecentPhotosDAO
}