package macwan.robinson.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import macwan.robinson.jetpackcomposedemo.ui.HomeScreen
import macwan.robinson.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme


class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                HomeScreen()
            }
        }
    }
}