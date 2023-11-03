package presentation.detailsScreen.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import data.remoteDataSource.model.DetailedPhotoInfoModel

@Composable
fun detailedPhotoInfoModelState(
    detailedPhotoInfoModel: DetailedPhotoInfoModel?
):MutableState<DetailedPhotoInfoModel?>{
    val model = remember {
        mutableStateOf(detailedPhotoInfoModel)
    }
    return model
}

