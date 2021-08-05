package com.example.deliveryapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.models.receipes.RecipeResponse
import com.example.deliveryapp.models.recommended_foods.RecommendedResponse
import com.example.deliveryapp.repositories.RecipeDetailRepository
import com.example.deliveryapp.repositories.RecommendedFoodsRepository
import kotlinx.coroutines.launch

class RecipeFragmentViewModel : ViewModel() {

    var detailReceipt: MutableState<RecipeResponse?> = mutableStateOf(RecipeResponse())
    var recommendedFoods: MutableState<RecommendedResponse?> = mutableStateOf(RecommendedResponse())
    val loading = mutableStateOf(true)

    var id = mutableStateOf(-1)

    fun getRecipeDetailInfo() {

        viewModelScope.launch {

            RecipeDetailRepository.instanceOf()!!.getRecipeInformation(detailReceipt, id.value, loading)

        }
    }

    fun getRecommendedFoodsInfo(){

        viewModelScope.launch {

            RecommendedFoodsRepository.instanceOf()?.getRecommendedFoodsData(recommendedFoods)

        }

    }

}