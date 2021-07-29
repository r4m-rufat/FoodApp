package com.example.deliveryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.designs.RecipeDetail
import com.example.deliveryapp.utils.convertors.convertHTMLToString
import com.example.deliveryapp.viewmodels.RecipeFragmentViewModel
import org.jsoup.Jsoup

class RecipeFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val recipeViewModel = ViewModelProvider(requireActivity()).get(RecipeFragmentViewModel::class.java)
        arguments?.getInt("recipeID")?.let { id ->

            Toast.makeText(requireContext(), id.toString(), Toast.LENGTH_SHORT).show()
            recipeViewModel?.id?.value = id
            recipeViewModel?.getRecipeDetailInfo()

        }

        return ComposeView(requireContext()).apply {

            setContent {

                recipeViewModel?.detailReceipt?.value.title?.let {

                    val title = recipeViewModel?.detailReceipt!!.value?.spoonacularScore
                    val imageURL = recipeViewModel?.detailReceipt!!.value.image
                    val recipeDescription = recipeViewModel?.detailReceipt!!.value.summary
//                    val recipe = recipeDescription?.replace("\\<.*?\\>", "")
                    val recipe = convertHTMLToString(recipeDescription!!)
                    RecipeDetail(foodImage = imageURL, foodTitle = title.toString(), foodDescription = recipe)

                }
            }

        }
    }
}