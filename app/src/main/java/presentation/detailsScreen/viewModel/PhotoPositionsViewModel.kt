package presentation.detailsScreen.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.remoteDataSource.model.RecentPhotoIdModel
import domain.usecases.DownLoadPhotoFromInternetUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoPositionsViewModel(
    private val defaultPhotoId: String,
    private val serverId: String,
    private val recentPhotoIdModel: RecentPhotoIdModel?,
    private val secret:String
):ViewModel(){

    private val _imageLinkState = MutableStateFlow(
        DownLoadPhotoFromInternetUseCase.downloadPhotoFromInternet(
            photoId = defaultPhotoId,
            serverId = serverId,
            secret = secret
        )
    )
    val imageLinkState = _imageLinkState.asStateFlow()


     private val _imagePositionState = MutableStateFlow(
         0
     )
     val imagePositionState = _imagePositionState.asStateFlow()




    fun photoPositionNext(): String? {
        val currentIndex = _imagePositionState.value
        val newIndex = currentIndex + 1
        _imagePositionState.tryEmit(newIndex)

        val newPhotoId = recentPhotoIdModel?.photo?.get(newIndex)?.photoId
        if (!newPhotoId.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.Unconfined) {
                delay(5)
                _imageLinkState.emit(
                    DownLoadPhotoFromInternetUseCase.downloadPhotoFromInternet(
                        photoId = newPhotoId,
                        serverId = serverId,
                        secret = recentPhotoIdModel?.photo?.get(newIndex)?.secret ?: ""
                    )
                )
            }
        }

        return newPhotoId
    }


    fun photoPositionPrevious(): String? {
        val currentIndex = _imagePositionState.value
        if (currentIndex <= 0) {
            return null
        }

        val newIndex = currentIndex - 1
        _imagePositionState.tryEmit(newIndex)

        val previousPhotoId = recentPhotoIdModel?.photo?.get(newIndex)?.photoId
        if (!previousPhotoId.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.Unconfined) {
                delay(5)
                _imageLinkState.emit(
                    DownLoadPhotoFromInternetUseCase.downloadPhotoFromInternet(
                        photoId = previousPhotoId,
                        serverId = serverId,
                        secret = recentPhotoIdModel?.photo?.get(newIndex)?.secret ?: ""
                    )
                )
            }
        }

        return previousPhotoId
    }
}


class PhotoPositionViewModelFactory(
    private val defaultPhotoId: String,
    private val serverId: String,
    private val recentPhotoIdModel: RecentPhotoIdModel?,
    private val secret:String
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PhotoPositionsViewModel::class.java)){
            return PhotoPositionsViewModel(
                defaultPhotoId = defaultPhotoId,
                serverId = serverId,
                recentPhotoIdModel = recentPhotoIdModel,
                secret = secret
            ) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}