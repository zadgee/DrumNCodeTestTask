package data.event

sealed class SavingPhotoDetailsEvent{
    data class Success(val data: Unit?): SavingPhotoDetailsEvent()
    data class Error(val message: String?): SavingPhotoDetailsEvent()
}
