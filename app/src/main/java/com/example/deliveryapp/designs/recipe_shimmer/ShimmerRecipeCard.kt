package com.example.deliveryapp.designs.recipe_shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.designs.RecommendedFoodsWord
import com.example.deliveryapp.designs.recommended_shimmer.RecommendedShimmerCard

@Composable
fun ShimmerRecipeCard(
    modifier: Modifier = Modifier,
    brush: Brush,
    cardHeight: Dp,
    isRecomCardOn: Boolean
) {

    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        )
    ) {

        Spacer(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .height(cardHeight)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
                .background(brush = brush)
        )

        Spacer(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .height(30.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(brush = brush)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .height(25.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .height(25.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(brush = brush)
            )

        }

        Text(
            text = "Receipt",
            modifier = Modifier.padding(bottom = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontStyle = FontStyle.Italic
        )

        for (i in 1..10){
            ShimmerText(brush = brush)
        }

        /**
         * because recommended card is only available in RecipeFragment
         * in RecommendedRecipeDetail fragment not available
         */
        if (isRecomCardOn){
            RecommendedFoodsWord()

            LazyRow {
                repeat(5){
                    item {
                        RecommendedShimmerCard(brush = brush)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))

    }

}

@Composable
fun ShimmerText(
    brush: Brush
) {

    Spacer(
        modifier = Modifier
            .padding(bottom = 5.dp)
            .fillMaxWidth()
            .height(10.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(brush = brush)
    )

}

