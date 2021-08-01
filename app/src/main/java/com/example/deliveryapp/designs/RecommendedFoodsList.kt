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
fun RecommendedFoodsList(
    modifier: Modifier,
    foodsList: List<ResultsItem?>,
    onClickItem: (index: Int) -> Unit
) {

    val state = rememberLazyListState()
    val readyTimeList = getDefaultReadyTimeList()
    val ratingList = getDefaultRatingList()

    LazyRow(modifier = modifier, state = state) {

        itemsIndexed(items = foodsList) { index, item ->

            RecommendedFoodCard(
                item,
                readyTime = readyTimeList[index].toString(),
                rating = ratingList[index].toString(),
                onCLick = {  id ->
                    onClickItem(id)
                }
            )

        }

    }

}