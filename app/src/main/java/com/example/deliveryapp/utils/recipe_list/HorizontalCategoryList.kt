package com.example.deliveryapp.utils.recipe_list

import com.example.deliveryapp.utils.recipe_list.HorizontalCategoryList.*

enum class HorizontalCategoryList(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    PIZZA("Pizza"),
    PASTA("Pasta"),
    DESSERT("Dessert"),
}

fun getAllFoodCategories(): List<HorizontalCategoryList> {

    return listOf(
        CHICKEN,
        BEEF,
        SOUP,
        VEGAN,
        VEGETARIAN,
        MILK,
        PIZZA,
        PASTA,
        DESSERT
    )

}

fun getAllFoodCategoriesValue(): List<String> {
    var list = mutableListOf<String>()

    getAllFoodCategories().forEach{category ->

        list.add(category.value)

    }

    return list

}

