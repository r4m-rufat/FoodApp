package com.example.deliveryapp.designs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel

@Composable
fun MenuList(
    modifier: Modifier = Modifier,
    menuList: List<String>,
    viewModel: SelectedCategoryViewModel,
    homeViewModel: HomeActivityViewModel,
) {
    LazyRow(modifier = modifier) {

        itemsIndexed(items = menuList) { _, item ->

            CardItem(
                modifier = Modifier.padding(5.dp),
                item = item,
                selectedCategoryViewModel = viewModel,
                homeActivityViewModel = homeViewModel,
                selectedCategory = item,
            )

        }

    }

}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    item: String,
    selectedCategoryViewModel: SelectedCategoryViewModel,
    homeActivityViewModel: HomeActivityViewModel,
    selectedCategory: String,
) {

    Card(
        modifier = modifier.clickable(
            enabled = true,
            onClick = {
                selectedCategoryViewModel.selectedCategoryChanged(selectedCategory)
                homeActivityViewModel.query.value = selectedCategoryViewModel.selectedCategory.value
                homeActivityViewModel.onCategorySelected(homeActivityViewModel.query.value)
            }
        ),
        elevation = 3.dp,
        shape = RoundedCornerShape(5.dp),
        backgroundColor = if (selectedCategoryViewModel.selectedCategory.value == selectedCategory) Color.Cyan else Color.Blue
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            text = item,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        )

    }

}