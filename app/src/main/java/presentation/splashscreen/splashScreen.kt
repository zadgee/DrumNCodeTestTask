package presentation.splashscreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.testtaskdrumncode.ui.theme.MyColors


@Composable
fun LoadingScreen(
    modifier:Modifier = Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ){
      CircularProgressIndicator(
         color = MyColors.blue
      )
    }
}