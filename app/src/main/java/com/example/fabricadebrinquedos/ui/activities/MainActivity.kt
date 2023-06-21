package com.example.fabricadebrinquedos.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fabricadebrinquedos.dao.ProductDao
import com.example.fabricadebrinquedos.model.Product
import com.example.fabricadebrinquedos.sampledata.sampleCasuals
import com.example.fabricadebrinquedos.sampledata.sampleProducts
import com.example.fabricadebrinquedos.sampledata.sampleSections
import com.example.fabricadebrinquedos.sampledata.sampleSocials
import com.example.fabricadebrinquedos.ui.screens.HomeScreen
import com.example.fabricadebrinquedos.ui.screens.HomeScreenUiState
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme


class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(
                    Intent(
                        this,
                        ProductFormActivity::class.java
                    )
                )
            }) {
                val products = dao.products()
                HomeScreen(products = products)
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    FabricaDeBrinquedosTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App {
        HomeScreen(HomeScreenUiState(sections = sampleSections))
    }
}


