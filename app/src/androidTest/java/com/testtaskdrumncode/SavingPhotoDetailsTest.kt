package com.testtaskdrumncode

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import data.localDataSource.dao.PhotoDetailsDAO
import data.localDataSource.db.PhotoAndDetailsDataBase
import domain.entities.PhotoDetailsEntity
import domain.repository.PhotoDetailsRepository
import data.localDataSource.repositoryImpl.PhotoDetailsRepositoryImpl
import domain.entities.DetailedPhotoInfoModel
import domain.entities.OwnerModel
import domain.entities.TitleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class SavingPhotoDetailsTest{
    private lateinit var photoDetailsDataBase:PhotoAndDetailsDataBase
    private lateinit var context: Context
    private lateinit var dao: PhotoDetailsDAO
    private lateinit var repository: PhotoDetailsRepository
    private val testingScope = CoroutineScope(Dispatchers.Unconfined)
    private val testDetails = PhotoDetailsEntity(
        retrievedPhotoId = "testPhotoId",
        photoDetails = DetailedPhotoInfoModel(
            secret = "testSecret",
            ownerModel = OwnerModel(
                username = "testUsername",
                realName = "testRealName"
            ),
            titleModel = TitleModel(
                title = "testTitle"
            )
        )
    )


    @Before
    fun setUpRepository(){
        context = ApplicationProvider.getApplicationContext()
        photoDetailsDataBase = Room.databaseBuilder(
            context = this.context,
            PhotoAndDetailsDataBase::class.java,
            "Photo_Details_DB"
        )
            .fallbackToDestructiveMigration()
            .build()
        dao = photoDetailsDataBase.photoDetailsDao()
        repository = PhotoDetailsRepositoryImpl(
            dao
        )
    }



    @Test
    fun is_photo_details_saved_in_database() {
        testingScope.launch {
            repository.savePhotoDetails(
                testDetails
            )
        }
    }

    @Test
    fun are_photoDetails_retrieving_by_photoId(){
        testingScope.launch {
            repository.getPhotoDetails(
                "testPhotoId"
            )
        }
    }
}