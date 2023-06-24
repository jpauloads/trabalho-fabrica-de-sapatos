package com.example.fabricadebrinquedos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fabricadebrinquedos.sampledata.sampleSections
import com.example.fabricadebrinquedos.ui.components.CardProductItem
import com.example.fabricadebrinquedos.ui.components.ProductsSection
import com.example.fabricadebrinquedos.ui.components.SearchTextField
import com.example.fabricadebrinquedos.ui.states.HomeScreenUiState
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme
import com.example.fabricadebrinquedos.ui.viewmodels.HomeScreenViewModel

//stateful composable
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

//stateless
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