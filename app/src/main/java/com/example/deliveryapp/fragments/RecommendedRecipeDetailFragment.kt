package com.example.deliveryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.designs.RecommendedDetailScreen
import com.example.deliveryapp.viewmodels.RecommendedDetailViewModel

class RecommendedRecipeDetailFragment : Fragment() {

    private lateinit var viewModel: RecommendedDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("recID")?.let { id ->

            viewModel = ViewModelProvider(this).get(RecommendedDetailViewModel::class.java)
            viewModel.foodID.value = id
            viewModel.getRecommendedFoodReceipt()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireActivity()).apply {

            setContent {

                viewModel.recommendedReceipt.value?.let { recipeResponse ->

                    RecommendedDetailScreen(
                        recipe = recipeResponse,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                }

            }

        }
    }
}