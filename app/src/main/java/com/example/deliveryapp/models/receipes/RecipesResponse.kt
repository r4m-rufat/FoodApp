package com.example.deliveryapp.models.receipes

data class RecipesResponse(
	val number: Int? = null,
	val totalResults: Int? = null,
	val offset: Int? = null,
	val results: List<ResultsItem?>? = null
)
