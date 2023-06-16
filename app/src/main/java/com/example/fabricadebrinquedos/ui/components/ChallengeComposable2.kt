package com.example.fabricadebrinquedos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fabricadebrinquedos.R

@Preview(showBackground = true)
@Composable
fun ChallengeComposable2() {
    Surface(
//        Modifier.padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colors.primary,
                                MaterialTheme.colors.secondary
                            )
                        )
                    )
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.CenterEnd)
                        .border(
                            width = 2.dp,
                            brush = Brush.verticalGradient(
                                listOf(
                                    MaterialTheme.colors.primary,
                                    MaterialTheme.colors.secondary
                                )
                            ),
                            shape = CircleShape
                        )
                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))
            Text(
                text = LoremIpsum(50).values.first(),
                Modifier
                    .padding(all = 16.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}