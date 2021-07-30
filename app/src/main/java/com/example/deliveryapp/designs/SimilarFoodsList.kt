package com.example.deliveryapp.designs

import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimilarFoodsList() {

    Row(modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())) {
        for (i in 1..10){
            SimilarFoodCard()
        }
    }

}