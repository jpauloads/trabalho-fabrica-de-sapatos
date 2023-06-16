package com.example.fabricadebrinquedos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fabricadebrinquedos.model.Product
import com.example.fabricadebrinquedos.sampledata.sampleProducts
import com.example.fabricadebrinquedos.sampledata.sampleSections
import com.example.fabricadebrinquedos.ui.components.CardProductItem
import com.example.fabricadebrinquedos.ui.components.ProductsSection
import com.example.fabricadebrinquedos.ui.components.SearchTextField
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = "",
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }
        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            },
        )
        val searchedProducts = remember(text) {
            sampleProducts.filter { product ->
                product.name.contains(
                    text,
                    ignoreCase = true,
                ) ||
                        product.description?.contains(
                            text,
                            ignoreCase = true,
                        ) ?: false
            }
        }
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            }
            items(searchedProducts) { p ->
                CardProductItem(
                    product = p,
                    Modifier.padding(horizontal = 16.dp)
                )
            }
            for (section in sections) {
                val title = section.key
                val products = section.value
                item {
                    ProductsSection(
                        title = title,
                        products = products
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    FabricaDeBrinquedosTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchText() {
    FabricaDeBrinquedosTheme {
        Surface {
            HomeScreen(
                sampleSections,
                searchText = "a",
            )
        }
    }
}