package com.testtaskdrumncode
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.testtaskdrumncode.ui.theme.MyColors
import com.testtaskdrumncode.ui.theme.TestTaskDrumNCodeTheme
import dagger.hilt.android.AndroidEntryPoint
import presentation.app_navigation.AppNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTaskDrumNCodeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyColors.orange
                ) {
                    AppNavigation()
                }
            }
        }
    }
}