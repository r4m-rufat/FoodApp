package com.example.deliveryapp.designs.recipe_list_shimmer

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.designs.recipe_list_shimmer.ShimmerFoodCard

@Composable
fun ShimmerAnimation(
    modifier: Modifier = Modifier
) {

    val transition = rememberInfiniteTransition()
    val translateAnimation1 by transition.animateFloat(
        initialValue = -200f,
        targetValue = 1100f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1300,
                easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )

    val translateAnimation2 by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1300f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1300,
                easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )

    val shimmerColorShades = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.1f),
        Color.LightGray.copy(alpha = 0.9f)
    )

    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(translateAnimation1, translateAnimation1),
        end = Offset(translateAnimation2, translateAnimation2)
    )

    ShimmerFoodCard(
        modifier = modifier,
        brush = brush,
        cardHeight = 250.dp
    )

}