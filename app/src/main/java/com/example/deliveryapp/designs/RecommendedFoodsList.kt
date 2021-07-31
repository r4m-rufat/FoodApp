package com.example.deliveryapp.designs

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.deliveryapp.default_data.getDefaultRatingList
import com.example.deliveryapp.default_data.getDefaultReadyTimeList
import com.example.deliveryapp.models.recommended_foods.ResultsItem

@Composable
fun SimilarFoodsList(
    modifier: Modifier,
    foodsList: List<ResultsItem?>
) {

    val state = rememberLazyListState()
    val readyTimeList = getDefaultReadyTimeList()
    val ratingList = getDefaultRatingList()

    LazyRow(modifier = modifier, state = state) {

        itemsIndexed(items = foodsList) { index, item ->

            RecommendedFoodCard(
                imageUrl = item?.image!!,
                title = item.title!!,
                readyTime = readyTimeList[index].toString(),
                rating = ratingList[index].toString()
            )

        }

    }

}