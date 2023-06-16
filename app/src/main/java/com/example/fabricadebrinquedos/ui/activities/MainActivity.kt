package com.example.fabricadebrinquedos.ui.activities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.fabricadebrinquedos.sampledata.sampleSections
import com.example.fabricadebrinquedos.ui.screens.HomeScreen
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    FabricaDeBrinquedosTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}




