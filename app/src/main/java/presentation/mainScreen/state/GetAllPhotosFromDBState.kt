package presentation.mainScreen.state

import domain.entities.RecentPhotoBasicInfoEntity

data class GetAllPhotosFromDBState(
    val error:String? = null,
    val success: RecentPhotoBasicInfoEntity? = null
)
