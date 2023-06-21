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
import com.example.fabricadebrinquedos.sampledata.sampleCasuals
import com.example.fabricadebrinquedos.sampledata.sampleProducts
import com.example.fabricadebrinquedos.sampledata.sampleSections
import com.example.fabricadebrinquedos.sampledata.sampleSocials
import com.example.fabricadebrinquedos.ui.components.CardProductItem
import com.example.fabricadebrinquedos.ui.components.ProductsSection
import com.example.fabricadebrinquedos.ui.components.SearchTextField
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }

}

//stateless
@Composable
fun HomeScreen(
    products: List<Product>
) {
    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleCasuals + sampleSocials,
        "Casuais" to sampleCasuals,
        "Sociais" to sampleSocials
    )
    var text by remember {
        mutableStateOf("")
    }

    fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) ||
                product.description?.contains(
                    text,
                    ignoreCase = true,
                ) ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())
        } else emptyList()
    }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }
    HomeScreen(state = state)
}

//stateful
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
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
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp)
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
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchText() {
    FabricaDeBrinquedosTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(searchText = "a", sections = sampleSections)
            )
        }
    }
}