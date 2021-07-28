package com.example.deliveryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.designs.FoodList
import com.example.deliveryapp.designs.MenuList
import com.example.deliveryapp.designs.TextFieldDesign
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.utils.recipe_list.getAllFoodCategoriesValue
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel

class RecipeListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            var viewModelProvider = ViewModelProvider(requireActivity()).get(HomeActivityViewModel::class.java)
            var selectedCategoryViewModel =
                ViewModelProvider(requireActivity()).get(SelectedCategoryViewModel::class.java)
            viewModelProvider.query.value = selectedCategoryViewModel.selectedCategory.value

            setContent {
                DeliveryAppTheme {

                    Column(modifier = Modifier.fillMaxSize()) {

                        TextFieldDesign(onClick = { text, scrollPosition ->
                            viewModelProvider.query.value = text
                            viewModelProvider.resetSearchState()
                        })
                        Spacer(modifier = Modifier.height(5.dp))
                        MenuList(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxWidth(),
                            menuList = getAllFoodCategoriesValue(),
                            selectedCategoryViewModel,
                            homeViewModel = viewModelProvider
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        val deliveryList = viewModelProvider.deliveryList.value

                        val page = viewModelProvider.page.value

                        deliveryList?.let { recipes ->

                            FoodList(
                                recipes = recipes,
                                modifier = Modifier.padding(horizontal = 10.dp),
                                page = page,
                                viewModelProvider = viewModelProvider)
                        }

                    }
                }

            }
        }
    }
}