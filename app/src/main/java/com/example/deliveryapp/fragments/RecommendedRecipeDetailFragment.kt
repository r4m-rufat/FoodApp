package com.example.deliveryapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.R
import com.example.deliveryapp.designs.ConnectionSnackbar
import com.example.deliveryapp.designs.recipe_shimmer.RecipeItemShimmerAnimation
import com.example.deliveryapp.designs.RecommendedDetailScreen
import com.example.deliveryapp.designs.TopAppBar
import com.example.deliveryapp.utils.TAG
import com.example.deliveryapp.utils.connection.ConnectionLiveData
import com.example.deliveryapp.viewmodels.RecommendedDetailViewModel

class RecommendedRecipeDetailFragment : Fragment() {

    private lateinit var viewModel: RecommendedDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecommendedDetailViewModel::class.java)
        arguments?.getInt("recID")?.let { id ->

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

                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                Scaffold(scaffoldState = scaffoldState) {
                    SetAllOfWidgets()
                    if (!ConnectionLiveData.observeAsState(true).value) {
                        ConnectionSnackbar(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            scaffoldState = scaffoldState,
                            scope = scope
                        )
                        Log.d(TAG, "onCreateView: Connection is lost")
                    } else {
                        Log.d(TAG, "onCreateView: Connection comes")
                    }

                }

            }

        }
    }

    @Composable
    fun SetAllOfWidgets() {

        Column(modifier = Modifier.fillMaxWidth()) {

            TopAppBar(
                title = "Recommended Food",
                icon = painterResource(id = R.drawable.icon),
                isMenuOn = false,
                modifier = Modifier.fillMaxWidth()
            )

            if (viewModel.loading.value){
                RecipeItemShimmerAnimation(
                    modifier = Modifier
                        .padding(10.dp),
                    isRecomCardOn = false // recommended card doesn't have
                )
            }else{
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