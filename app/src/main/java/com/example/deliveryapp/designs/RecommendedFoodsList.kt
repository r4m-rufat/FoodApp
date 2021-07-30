package com.example.deliveryapp.designs

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.deliveryapp.models.foods.ResultsItem

@Composable
fun SimilarFoodsList(
    modifier: Modifier,
    foodsList: List<ResultsItem?>
) {

    val state = rememberLazyListState()

    LazyRow(modifier = modifier, state = state) {

        itemsIndexed(items = foodsList) { index, item ->

            RecommendedFoodCard(imageUrl = foodsList[index]?.image!!, title = foodsList[index]?.title!!)

        }

    }

}