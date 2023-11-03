package data.event

import data.localDataSource.model.PhotoDetailsEntity

sealed class GetPhotoDetailsFromDBEvent {
    data class Success(val data:PhotoDetailsEntity): GetPhotoDetailsFromDBEvent()
    data class Error(val message:String): GetPhotoDetailsFromDBEvent()
}
