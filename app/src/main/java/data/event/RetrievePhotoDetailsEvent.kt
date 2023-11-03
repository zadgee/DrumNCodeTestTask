package data.event
import data.remoteDataSource.model.DetailedPhotoInfo
import retrofit2.Response

sealed class RetrievePhotoDetailsEvent{
    data class Success(val data:Response<DetailedPhotoInfo>):RetrievePhotoDetailsEvent()
    data class Error(val message:String):RetrievePhotoDetailsEvent()
}
