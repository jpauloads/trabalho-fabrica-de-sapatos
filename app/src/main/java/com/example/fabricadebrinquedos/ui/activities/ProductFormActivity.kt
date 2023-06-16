package com.example.fabricadebrinquedos.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fabricadebrinquedos.R
import com.example.fabricadebrinquedos.model.Product
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme
import java.math.BigDecimal

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FabricaDeBrinquedosTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }
    }

    @Composable
    fun ProductFormScreen() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier)
            Text(
                text = "Criando o produto",
                Modifier.fillMaxWidth(),
                fontSize = 28.sp,
            )

            var url by remember {
                mutableStateOf("")
            }

            if (url.isNotBlank()) {
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder)
                )
            }

            TextField(
                value = url,
                onValueChange = {
                    url = it
                },
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Url da imagem")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Next,
                )
            )

            var name by remember {
                mutableStateOf("")
            }
            TextField(
                value = name,
                onValueChange = {
                    name = it
                },
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Nome do produto")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                )
            )

            var price by remember {
                mutableStateOf("")
            }
            TextField(
                value = price,
                onValueChange = {
                    price = it
                },
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Preço")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next,
                )
            )

            var description by remember {
                mutableStateOf("")
            }
            TextField(
                value = description,
                onValueChange = {
                    description = it
                },
                Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp),
                label = {
                    Text(text = "Descrição")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                )
            )

            Button(
                onClick = {
                    val convertedPrice = try {
                        BigDecimal(price)
                    } catch (e: NumberFormatException) {
                        BigDecimal.ZERO
                    }
                    val product = Product(
                        name = name,
                        image = url,
                        price = convertedPrice,
                        description = description
                    )
                    Log.i("ProductFormActivity", "ProductFormScreen: $product")
                },
                Modifier.fillMaxWidth(),
            ) {
                Text(text = "Salvar")
            }
            Spacer(modifier = Modifier)
        }
    }

    @Preview
    @Composable
    fun ProductFormScreenPreview() {
        FabricaDeBrinquedosTheme {
            Surface {
                ProductFormScreen()
            }
        }
    }
}