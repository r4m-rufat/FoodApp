package com.example.deliveryapp.models

data class ComplexResponse(
	val number: Int? = null,
	val totalResults: Int? = null,
	val offset: Int? = null,
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(
	val image: String? = null,
	val id: Int? = null,
	val title: String? = null,
	val imageType: String? = null
)

