package com.example.fabricadebrinquedos.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fabricadebrinquedos.sampledata.sampleProducts

@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "icone de busca")
        },
        label = {
            Text(text = ("Produto"))
        },
        placeholder = {
            Text(text = "O que você procura?")
        }
    )
}