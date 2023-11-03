package presentation.mainScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.event.RetrieveRecentPhotosInfoEvent
import data.localDataSource.model.RecentPhotoBasicInfoEntity
import domain.usecases.DeletePhotosListFromDBUseCase
import domain.usecases.GetAllPhotosFromDBUseCase
import domain.usecases.RetrieveRecentPhotosInfoUseCase
import domain.usecases.SavePhotoListFromInternetToDBUseCase
import domain.usecases.UpdateListWithPhotosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.mainScreen.state.GetPhotosFromInternetState
import javax.inject.Inject

@HiltViewModel
class PhotosListViewModel @Inject constructor(
    private val retrieveRecentPhotosInfoUseCase: RetrieveRecentPhotosInfoUseCase,
    private val savePhotoListFromInternetToDBUseCase: SavePhotoListFromInternetToDBUseCase,
    private val getAllPhotosFromDBUseCase: GetAllPhotosFromDBUseCase,
    private val deletePhotosListFromDBUseCase: DeletePhotosListFromDBUseCase,
    private val updateListWithPhotosUseCase: UpdateListWithPhotosUseCase,
):ViewModel() {

    private val _recentPhotosState = MutableStateFlow(GetPhotosFromInternetState())
    val recentPhotosState = _recentPhotosState.asStateFlow()

    private val _gettingPhotosListFromDatabaseState = MutableStateFlow<RecentPhotoBasicInfoEntity?>(
        null
    )
    val gettingPhotosListFromDatabaseState = _gettingPhotosListFromDatabaseState.asStateFlow()





    fun getAllPhotos(){
        viewModelScope.launch(Dispatchers.IO) {
             when(val result = retrieveRecentPhotosInfoUseCase.getPhotosInfo()){
                 is RetrieveRecentPhotosInfoEvent.Error ->{
                     _recentPhotosState.emit(
                         GetPhotosFromInternetState(
                             error = result.message,
                             success = null
                         )
                     )
                 }
                 is RetrieveRecentPhotosInfoEvent.Success -> {
                     _recentPhotosState.emit(
                         GetPhotosFromInternetState(
                             error = null,
                             success = result.data
                         )
                     )
                 }
             }
        }
    }

    fun saveListWithPhotos(photos: RecentPhotoBasicInfoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            savePhotoListFromInternetToDBUseCase.saveListWithPhotos(photos)
        }
    }

    fun getPhotoListFromDB(){
        viewModelScope.launch(Dispatchers.IO){
            val data = getAllPhotosFromDBUseCase.getAllPhotos()
            _gettingPhotosListFromDatabaseState.emit(
                data
            )
        }
    }

    fun deletePhotoListFromDB(photos: RecentPhotoBasicInfoEntity){
        viewModelScope.launch(Dispatchers.IO){
          deletePhotosListFromDBUseCase.deleteAllPhotos(photos)
        }
    }

    fun updatePhotoListEntity(
        photos: RecentPhotoBasicInfoEntity
    ){
        viewModelScope.launch(Dispatchers.IO) {
            updateListWithPhotosUseCase.updateListWithPhotos(photos)
        }
    }

}