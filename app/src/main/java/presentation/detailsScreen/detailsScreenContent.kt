package presentation.detailsScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.testtaskdrumncode.R


@Composable
fun DetailsScreenContent(
    title:String,
    userName:String,
    realName:String,
    imageLink:String,
    goBackToMainScreen:()->Unit,
    onNextClick:()->Unit,
    onPreviousClick:()->Unit
    ){
    Column{

        IconButton(onClick = goBackToMainScreen) {
            Icon(painter = painterResource(
                id = R.drawable.back_arrow),
                contentDescription = "Back Arrow",
            )
        }

        AsyncImage(
            model = imageLink,
            contentDescription = "Image",
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = title,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Text(
            text = userName,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Real name :$realName",
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = onNextClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Next"
            )
        }

        Button(
            onClick = onPreviousClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text (
                text = "Back"
            )
        }
    }

}