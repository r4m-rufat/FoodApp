package com.example.deliveryapp.designs.recipe_list_shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerFoodCard(
    modifier: Modifier = Modifier,
    brush: Brush,
    cardHeight: Dp
) {

    Column(modifier = modifier) {

        Spacer(modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(cardHeight)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = brush))

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(brush = brush))

    }


}

@Preview(showBackground = true)
@Composable
fun PreviewShimmer() {

    ShimmerAnimation()

}