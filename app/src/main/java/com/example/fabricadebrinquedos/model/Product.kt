package com.example.fabricadebrinquedos.model

import androidx.annotation.DrawableRes
import com.example.fabricadebrinquedos.R
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null
) {

}
