package com.example.fabricadebrinquedos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fabricadebrinquedos.R
import com.example.fabricadebrinquedos.extensions.toBrazilianCurrency
import com.example.fabricadebrinquedos.model.Product
import com.example.fabricadebrinquedos.ui.theme.FabricaDeBrinquedosTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    isExpanded: Boolean = false
) {
    var expandedState by rememberSaveable { mutableStateOf(isExpanded) }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expandedState = !expandedState
            },
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
//            val textOverflow =
//                if (expandedState) TextOverflow.Visible
//                else TextOverflow.Ellipsis
//            val maxLines =
//                if (expandedState) Int.MAX_VALUE
//                else 2
            if (expandedState) {
                product.description?.let {
                    Text(
                        text = product.description,
                        Modifier
                            .padding(16.dp),
//                    overflow = textOverflow,
//                    maxLines = maxLines
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    FabricaDeBrinquedosTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal("9.99")
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductIteWithDescriptionPreview() {
    FabricaDeBrinquedosTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal("9.99"),
                    description = LoremIpsum(50).values.first()
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionExpandedPreview() {
    FabricaDeBrinquedosTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal("9.99"),
                    description = LoremIpsum(50).values.first()
                ),
                isExpanded = true,
            )
        }
    }
}