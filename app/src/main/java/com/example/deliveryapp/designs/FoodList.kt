package com.example.deliveryapp.designs

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.models.foods.ResultsItem
import com.example.deliveryapp.utils.PAGE_SIZE
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FoodList(
    modifier: Modifier = Modifier,
    recipes: List<ResultsItem?>?,
    viewModelProvider: HomeActivityViewModel,
    page: Int,
    onCLickItem: (index: Int) -> Unit
) {

    val listState = rememberLazyListState()

    // remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = modifier, state = listState) {

        itemsIndexed(items = recipes!!) { index, item ->

            viewModelProvider.onChangeScrollPosition(index)

            /**
             * pagination statement
             */
            if ((index + 1) >= (page * PAGE_SIZE)) {

                viewModelProvider.nextRecipePage()

            }
            RecipeCard(
                recipe = item,
                modifier = Modifier.padding(vertical = 10.dp),
                onClickCard = {
                    onCLickItem(it)
                }
            )

        }

    }

    if (viewModelProvider.scrollPositionInSearch.value) {
        coroutineScope.launch {
            listState.animateScrollToItem(0)
        }
    }

}

