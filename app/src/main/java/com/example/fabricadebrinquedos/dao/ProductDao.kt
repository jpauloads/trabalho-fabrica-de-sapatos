package com.example.fabricadebrinquedos.dao

import com.example.fabricadebrinquedos.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {

    companion object {
        private val products =
            MutableStateFlow<List<Product>>(emptyList()) //no momento inicial é uma lista vazia
    }

    fun products() = products.asStateFlow()
    //fun products(): StateFlow<List<Producst>> = preducts

    fun save(product: Product) {
        products.value = products.value + product
    }
}