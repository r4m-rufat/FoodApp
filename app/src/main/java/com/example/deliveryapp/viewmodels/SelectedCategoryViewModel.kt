package com.example.deliveryapp.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SelectedCategoryViewModel: ViewModel() {

    val selectedCategory = mutableStateOf("")

    // when selected category chip it is written the "selectedCategory"
    fun selectedCategoryChanged(category: String){

        selectedCategory.value = category

    }

}