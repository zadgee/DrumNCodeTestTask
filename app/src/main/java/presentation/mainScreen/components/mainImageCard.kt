package presentation.mainScreen.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.testtaskdrumncode.ui.theme.MyColors
import data.remoteDataSource.model.IdList

@Composable
fun MainScreenCardModel(
    modifier:Modifier = Modifier,
    onImageClick:(serverId:String,photoId:String,secret:String)->Unit,
    imageLink:String,
    idList: IdList?,
){

    Card(
     shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
         containerColor = MyColors.green
        )
    ){
        IconButton(onClick = {
            onImageClick(
                idList?.serverId ?: "",
                idList?.photoId ?: "",
                idList?.secret ?:""
            )
        }) {
            AsyncImage(
                model = imageLink,
                contentDescription = "Parsed image",
                modifier = modifier.clip(CircleShape).size(80.dp).fillMaxWidth()
            )
        }

        Text(
            text  = idList?.title ?:"Title equals null",
            color = Color.White
        )
    }

}