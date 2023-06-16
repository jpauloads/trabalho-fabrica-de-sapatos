package com.example.fabricadebrinquedos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ChallengeComposable() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(90.dp)
                .background(Color.Blue)
                .width(50.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(8.dp), text = "Test 1"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), text = "Test 2"
            )
        }
    }
}