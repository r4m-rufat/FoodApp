package com.example.deliveryapp.designs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun RecommendedDetailScreen(
    modifier: Modifier = Modifier,
    foodImage: String? = null,
    foodTitle: String? = null,
    foodDescription: String? = null,
    readyTime: String? = null,
    healthScore: String? = null,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(
                topEnd = 10.dp,
                topStart = 10.dp
            ),
            border = BorderStroke(2.dp, Color(0xFFFBF00))
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                Image(
                    painter = rememberImagePainter(data = foodImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(scaleX = 1.1f, scaleY = 1f),
                    contentScale = ContentScale.Crop
                )
            }

        }

        Text(
            text = foodTitle!!,
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                vertical = 10.dp,
                horizontal = 30.dp
            ),
            fontWeight = FontWeight.Bold
        )

        RecipeHealthTimeContainer(
            healthScore = healthScore!!,
            readyTime = readyTime!!,
            modifier = modifier
        )

        Text(
            text = "Receipt",
            modifier = Modifier.padding(
                top = 24.dp
            ),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = foodDescription!!,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 20.dp
            ),
            fontSize = 14.sp,
            color = Color.Black,
            lineHeight = 20.sp,
        )

    }

}