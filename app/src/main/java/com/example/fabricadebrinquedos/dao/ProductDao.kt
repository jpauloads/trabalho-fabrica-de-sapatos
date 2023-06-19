package com.example.fabricadebrinquedos.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.fabricadebrinquedos.model.Product

class ProductDao {

    //Ajuste o DAO para que a lista seja uma implementação de SnapshotStateList. Você pode usar a função
    companion object {                                       // * transformar a referencia em array
        private val products = mutableStateListOf<Product>()//*sampleProducts.toTypedArray()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }
}