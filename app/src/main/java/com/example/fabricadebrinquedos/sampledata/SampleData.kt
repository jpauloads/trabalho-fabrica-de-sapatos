package com.example.fabricadebrinquedos.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.fabricadebrinquedos.model.Product
import java.math.BigDecimal

val sampleCasuals = listOf(
    Product(
        name = "Nike",
        price = BigDecimal("399.99"),
        image = "https://images.pexels.com/photos/2529157/pexels-photo-2529157.jpeg",
        description = LoremIpsum(50).values.first()
    ),
    Product(
        name = "Adidas",
        price = BigDecimal("359.99"),
        image = "https://images.pexels.com/photos/812875/pexels-photo-812875.jpeg",
        description = LoremIpsum(30).values.first()
    ),
    Product(
        name = "All-Star",
        price = BigDecimal("199.99"),
        image = "https://images.pexels.com/photos/2946956/pexels-photo-2946956.jpeg",
        description = LoremIpsum(20).values.first()
    )
)

val sampleSocials = listOf(
    Product(
        name = "Sapato social",
        price = BigDecimal("155.98"),
        image = "https://images.pexels.com/photos/292998/pexels-photo-292998.jpeg",
        description = LoremIpsum(30).values.first()
    ),
    Product(
        name = "Salto alto",
        price = BigDecimal("219.99"),
        image = "https://images.pexels.com/photos/292998/pexels-photo-292998.jpeg",
        description = LoremIpsum(30).values.first()
    ),
    Product(
        name = "Tamanco",
        price = BigDecimal("79.99"),
        image = "https://images.pexels.com/photos/15916389/pexels-photo-15916389/free-photo-of-brilhante-luminoso-iluminado-inteligente.jpeg",
        description = LoremIpsum(10).values.first()
    ),
    Product(
        name = "Bota social",
        price = BigDecimal("299.99"),
        image = "https://images.pexels.com/photos/3075078/pexels-photo-3075078.jpeg"
    )
)

val sampleProducts: List<Product> = listOf(
    Product(
        name = "Sapatos",
        price = BigDecimal("159.99"),
        image = "https://images.pexels.com/photos/292999/pexels-photo-292999.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Product(
        name = "Chinelo",
        price = BigDecimal("39.99"),
        image = "https://images.pexels.com/photos/8456574/pexels-photo-8456574.jpeg"
    ),
    Product(
        name = "Sandália",
        price = BigDecimal("175.99"),
        image = "https://images.pexels.com/photos/112285/pexels-photo-112285.jpeg",
        description = LoremIpsum(50).values.first()
    ), *sampleSocials.toTypedArray(), *sampleCasuals.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Sociais" to sampleCasuals,
    "Casuais" to sampleSocials
)