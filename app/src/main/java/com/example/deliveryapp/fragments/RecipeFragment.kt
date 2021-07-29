package com.example.deliveryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.designs.RecipeDetail
import com.example.deliveryapp.utils.convertors.convertHTMLToString
import com.example.deliveryapp.viewmodels.RecipeFragmentViewModel

class RecipeFragment: Fragment() {

    private var recipeViewModel: RecipeFragmentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeViewModel = ViewModelProvider(requireActivity()).get(RecipeFragmentViewModel::class.java)
        arguments?.getInt("recipeID")?.let { id ->

            recipeViewModel?.id?.value = id
            recipeViewModel?.getRecipeDetailInfo()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {

            setContent {

                recipeViewModel?.detailReceipt?.value?.title?.let { title ->

                    val imageURL = recipeViewModel?.detailReceipt!!.value?.image
                    val recipeDescription = recipeViewModel?.detailReceipt!!.value?.summary
                    val recipe = convertHTMLToString(recipeDescription!!)
                    val time: String = when(val readyTime = recipeViewModel?.detailReceipt!!.value?.readyInMinutes) {
                        1 -> "$readyTime minute"
                        else -> "$readyTime minutes"
                    }
                    val healthScore = "Score: ${recipeViewModel?.detailReceipt!!.value?.healthScore}"
                    RecipeDetail(modifier = Modifier.padding(horizontal = 10.dp),
                        foodImage = imageURL,
                        foodTitle = title,
                        foodDescription = recipe,
                        healthScore = healthScore,
                        readyTime = time)

                }
            }

        }
    }
}