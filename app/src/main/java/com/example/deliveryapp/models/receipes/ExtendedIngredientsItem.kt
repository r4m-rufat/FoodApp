package com.example.deliveryapp.models.receipes

data class ExtendedIngredientsItem(
	val image: String? = null,
	val amount: Int? = null,
	val nameClean: String? = null,
	val original: String? = null,
	val aisle: String? = null,
	val consistency: String? = null,
	val originalName: String? = null,
	val unit: String? = null,
	val measures: Measures? = null,
	val meta: List<String?>? = null,
	val name: String? = null,
	val originalString: String? = null,
	val id: Int? = null,
	val metaInformation: List<String?>? = null
)
