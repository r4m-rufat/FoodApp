package com.example.deliveryapp.models.recommended_foods

data class StepsItem(
	val number: Int? = null,
	val ingredients: List<IngredientsItem?>? = null,
	val equipment: List<EquipmentItem?>? = null,
	val step: String? = null,
	val length: Length? = null
)
