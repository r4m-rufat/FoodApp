package com.example.deliveryapp.designs.recommended_shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RecommendedShimmerCard(
    brush: Brush
) {

    Card(
        modifier = Modifier
            .padding(end = 20.dp)
            .width(150.dp)
            .height(200.dp)
            .background(Color.White),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Spacer(
                modifier = Modifier
                    .size(150.dp)
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp,
                    bottom = 10.dp,
                    start = 8.dp,
                    end = 8.dp)
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(brush = brush)
            )

            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    )
                    .fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Spacer(
                    modifier = Modifier
                        .width(40.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(brush = brush)
                )

                Spacer(
                    modifier = Modifier
                        .width(40.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(brush = brush)
                )

            }

        }

    }

}