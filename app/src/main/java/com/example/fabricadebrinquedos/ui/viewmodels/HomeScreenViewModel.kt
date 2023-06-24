package com.example.fabricadebrinquedos.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fabricadebrinquedos.dao.ProductDao
import com.example.fabricadebrinquedos.model.Product
import com.example.fabricadebrinquedos.sampledata.sampleCasuals
import com.example.fabricadebrinquedos.sampledata.sampleProducts
import com.example.fabricadebrinquedos.sampledata.sampleSocials
import com.example.fabricadebrinquedos.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchText = it,
                        searchedProducts = searchedProducts(it)
                    )
                },
            )
        }

        viewModelScope.launch {
            dao.products().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos os produtos" to products,
                        "Promoções" to sampleSocials + sampleCasuals,
                        "Casuais" to sampleCasuals,
                        "Sociais" to sampleSocials
                    ),
                    searchedProducts = searchedProducts(_uiState.value.searchText)
                )
            }
        }
    }

    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) ||
                product.description?.contains(
                    text,
                    ignoreCase = true,
                ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> {
        return if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    dao.products().value.filter(containsInNameOrDescription(text))
        } else emptyList()
    }

}