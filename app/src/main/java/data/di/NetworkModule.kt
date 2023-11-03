package data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.remoteDataSource.api.FlickrAPI
import data.remoteDataSource.repository.RecentPhotosInternetRepository
import data.remoteDataSource.repository.RecentPhotosInternetRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkhttpForGeoCoding(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.flickr.com/services/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): FlickrAPI =
        retrofit.create(FlickrAPI::class.java)


    @Provides
    @Singleton
    fun provideRecentPhotoRepository(api: FlickrAPI): RecentPhotosInternetRepository =
        RecentPhotosInternetRepositoryImpl(api)

}