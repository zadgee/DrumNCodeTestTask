package presentation.mainScreen.state

import data.localDataSource.model.RecentPhotoBasicInfoEntity

data class GetAllPhotosFromDBState(
    val error:String? = null,
    val success:RecentPhotoBasicInfoEntity? = null
)
