package data.di
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.localDataSource.dao.PhotoDetailsDAO
import data.localDataSource.dao.RecentPhotosDAO
import data.localDataSource.db.PhotoAndDetailsDataBase
import data.localDataSource.repo.PhotoDetailsRepository
import data.localDataSource.repo.PhotoDetailsRepositoryImpl
import data.localDataSource.repo.RecentPhotoRepository
import data.localDataSource.repo.RecentPhotoRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context):PhotoAndDetailsDataBase{
        return Room.databaseBuilder(
            context.applicationContext,
            PhotoAndDetailsDataBase::class.java,
            "Photo_Details_DB"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePhotosDAO(photoAndDetailsDataBase: PhotoAndDetailsDataBase): PhotoDetailsDAO {
        return photoAndDetailsDataBase.photoDetailsDao()
    }

    @Provides
    @Singleton
    fun provideRecentPhotosDAO(
        photoAndDetailsDataBase: PhotoAndDetailsDataBase
    ):RecentPhotosDAO {
        return photoAndDetailsDataBase.recentPhotosDao()
    }


    @Provides
    @Singleton
    fun providePhotoDetailsRepository(
        photoDetailsDao: PhotoDetailsDAO
    ): PhotoDetailsRepository {
        return PhotoDetailsRepositoryImpl(
            photoDetailsDao
        )

    }

    @Provides
    @Singleton
    fun provideRecentPhotoRepository(
        recentPhotosDao: RecentPhotosDAO
    ): RecentPhotoRepository {
        return RecentPhotoRepositoryImpl(
            recentPhotosDao
        )
}

}