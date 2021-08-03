package com.example.deliveryapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.models.receipes.RecipeResponse
import com.example.deliveryapp.repositories.RecipeDetailRepository
import kotlinx.coroutines.launch

class RecommendedDetailViewModel: ViewModel() {

    var recommendedReceipt: MutableState<RecipeResponse?> = mutableStateOf(RecipeResponse())
    var foodID = mutableStateOf(-1)
    val loading = mutableStateOf(true)

    fun getRecommendedFoodReceipt(){

        viewModelScope.launch {

            RecipeDetailRepository.instanceOf()?.getRecipeInformation(recommendedReceipt, foodID.value, loading)

        }

    }

}