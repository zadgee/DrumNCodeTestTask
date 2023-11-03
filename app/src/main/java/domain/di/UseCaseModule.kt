package domain.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.localDataSource.repo.PhotoDetailsRepository
import data.localDataSource.repo.RecentPhotoRepository
import data.remoteDataSource.repository.RecentPhotosInternetRepository
import domain.usecases.DeletePhotoDetailsUseCase
import domain.usecases.DeletePhotosListFromDBUseCase
import domain.usecases.GetAllPhotosFromDBUseCase
import domain.usecases.GetPhotoDetailsByPhotoId
import domain.usecases.RetrievePhotoDetailsFromNetwork
import domain.usecases.RetrieveRecentPhotosInfoUseCase
import domain.usecases.SavePhotoDetailsUseCase
import domain.usecases.SavePhotoListFromInternetToDBUseCase
import domain.usecases.UpdateListWithPhotosUseCase
import domain.usecases.UpdatePhotoDetailsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule{

    @Provides
    @Singleton
    fun provideRetrieveRecentPhotosInfoUseCase(
        repository: RecentPhotosInternetRepository
    ): RetrieveRecentPhotosInfoUseCase {
        return RetrieveRecentPhotosInfoUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideRetrievePhotoDetailsUseCase(
        repository: RecentPhotosInternetRepository
    ):RetrievePhotoDetailsFromNetwork{
        return RetrievePhotoDetailsFromNetwork(
            repository
        )
    }


    @Provides
    @Singleton
    fun provideDeletePhotoDetailsUseCase(
        repository: PhotoDetailsRepository
    ): DeletePhotoDetailsUseCase {
        return DeletePhotoDetailsUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideSavePhotoDetailsUseCase(
        repository: PhotoDetailsRepository
    ): SavePhotoDetailsUseCase {
        return SavePhotoDetailsUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideGetPhotoDetailsByPhotoId(
        repository: PhotoDetailsRepository
    ): GetPhotoDetailsByPhotoId {
        return GetPhotoDetailsByPhotoId(
            repository
        )
    }


    @Provides
    @Singleton
    fun provideSavePhotoListFromInternetUseCase(
        repository: RecentPhotoRepository
    ): SavePhotoListFromInternetToDBUseCase{
        return SavePhotoListFromInternetToDBUseCase(
         repository
        )
    }


    @Provides
    @Singleton
    fun provideGetAllPhotosFromDBUseCase(
        repository: RecentPhotoRepository
    ): GetAllPhotosFromDBUseCase {
        return GetAllPhotosFromDBUseCase(
            repository
        )
    }




    @Provides
    @Singleton
    fun provideDeleteAllPhotosFromDBUseCase(
        repository: RecentPhotoRepository
    ): DeletePhotosListFromDBUseCase {
        return DeletePhotosListFromDBUseCase(
            repository
        )
    }



    @Provides
    @Singleton
    fun provideUpdateListWithPhotosUseCase(
        repository: RecentPhotoRepository
    ): UpdateListWithPhotosUseCase {
        return UpdateListWithPhotosUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideUpdatePhotoDetailsUseCase(
        repository: PhotoDetailsRepository
    ): UpdatePhotoDetailsUseCase {
        return UpdatePhotoDetailsUseCase(
            repository
        )
    }



}