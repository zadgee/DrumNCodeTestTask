package presentation.detailsScreen.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.localDataSource.model.PhotoDetailsEntity
import data.remoteDataSource.model.DetailedPhotoInfo
import domain.usecases.DeletePhotoDetailsUseCase
import domain.usecases.GetPhotoDetailsByPhotoId
import domain.usecases.RetrievePhotoDetailsFromNetwork
import domain.usecases.SavePhotoDetailsUseCase
import domain.usecases.UpdatePhotoDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel@Inject constructor(
    private val retrievePhotoDetailsFromNetwork: RetrievePhotoDetailsFromNetwork,
    private val savePhotoDetailsUseCase: SavePhotoDetailsUseCase,
    private val deletePhotoDetailsUseCase: DeletePhotoDetailsUseCase,
    private val getPhotoDetailsByPhotoIdUseCase: GetPhotoDetailsByPhotoId,
    private val updatePhotoDetailsUseCase: UpdatePhotoDetailsUseCase
    ):ViewModel() {


    private val _gettingPhotoDetailsFromDatabaseState = MutableStateFlow<PhotoDetailsEntity?>(
       null
    )
    val gettingPhotoDetailsFromDatabaseState = _gettingPhotoDetailsFromDatabaseState.asStateFlow()



    suspend fun getPhotosDetailsFromInternet(photoId:String):Response<DetailedPhotoInfo>{
      return withContext(Dispatchers.IO){
          retrievePhotoDetailsFromNetwork.getDetails(photoId)
      }
    }

    fun savePhotoDetails(photoDetails: PhotoDetailsEntity){
        viewModelScope.launch(Dispatchers.IO) {
            savePhotoDetailsUseCase.savePhotoDetails(photoDetails)
        }
    }

    fun getPhotoDetailsByPhotoId(
        photoId:String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            val data =  getPhotoDetailsByPhotoIdUseCase.getDetails(photoId)
           _gettingPhotoDetailsFromDatabaseState.emit(
               data
           )
            Log.d("TAG","Current data :$data")
        }
    }




    fun deletePhotoDetailsFromDataBase(photoDetails: PhotoDetailsEntity){
        viewModelScope.launch(Dispatchers.IO){
            deletePhotoDetailsUseCase.deletePhotoDetails(photoDetails)
        }
    }

    fun updatePhotoDetails(photoDetails: PhotoDetailsEntity){
        viewModelScope.launch(Dispatchers.IO){
           updatePhotoDetailsUseCase.updatePhotoDetails(
               photoDetails
           )
           delay(5)
           _gettingPhotoDetailsFromDatabaseState.emit(
               photoDetails
           )
        }
    }

}