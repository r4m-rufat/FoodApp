package com.example.deliveryapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.designs.CardItem
import com.example.deliveryapp.designs.FoodList
import com.example.deliveryapp.designs.MenuList
import com.example.deliveryapp.designs.TextFieldDesign
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.utils.recipe_list.getAllFoodCategoriesValue
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel

class HomeActivity : ComponentActivity() {

    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var viewModelProvider = ViewModelProvider(this).get(HomeActivityViewModel::class.java)
        var selectedCategoryViewModel = ViewModelProvider(this).get(SelectedCategoryViewModel::class.java)
        viewModelProvider.query.value = selectedCategoryViewModel.selectedCategory.value

        setContent {
            DeliveryAppTheme {

                Column(modifier = Modifier.fillMaxSize()) {

                    TextFieldDesign(onClick = {
                        text, scrollPosition ->
                        viewModelProvider.query.value = text
                        viewModelProvider.resetSearchState()
                    })
                    Spacer(modifier = Modifier.height(5.dp))
                    MenuList(modifier = Modifier.padding(horizontal = 5.dp).fillMaxWidth(), menuList = getAllFoodCategoriesValue(), selectedCategoryViewModel, homeViewModel = viewModelProvider)

                    Spacer(modifier = Modifier.height(5.dp))

                    val deliveryList = viewModelProvider.deliveryList.value

                    val page = viewModelProvider.page.value

                    deliveryList?.let {recipes ->

                        FoodList(recipes = recipes, modifier = Modifier.padding(horizontal = 10.dp), page = page, viewModelProvider = viewModelProvider)

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Column(modifier = Modifier.fillMaxSize()) {

    }
}

