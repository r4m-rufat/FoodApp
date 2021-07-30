package com.example.deliveryapp.models.recommended_foods

import com.example.deliveryapp.models.foods.ResultsItem

data class RecommendedResponse(
    val number: Int? = null,
    val totalResults: Int? = null,
    val offset: Int? = null,
    val results: List<ResultsItem?>? = null
)
