package com.example.deliveryapp.designs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel

@Composable
fun MenuList(
    modifier: Modifier = Modifier,
    menuList: List<String>,
    viewModel: SelectedCategoryViewModel
) {
    LazyRow(modifier = modifier) {

        itemsIndexed(items = menuList) { index, item ->

            CardItem(
                modifier = Modifier.padding(5.dp),
                item = item,
                selectedCategoryViewModel = viewModel,
                selectedCategory = item
            )

        }

    }

}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    item: String,
    selectedCategoryViewModel: SelectedCategoryViewModel,
    selectedCategory: String
) {

    Card(
        modifier = modifier.clickable(
            enabled = true,
            onClick = {
                selectedCategoryViewModel.selectedCategoryChanged(selectedCategory)
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