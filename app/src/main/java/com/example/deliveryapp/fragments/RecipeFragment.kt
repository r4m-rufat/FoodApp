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
import androidx.navigation.fragment.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.designs.ConnectionSnackbar
import com.example.deliveryapp.designs.RecipeDetail
import com.example.deliveryapp.designs.recipe_shimmer.RecipeItemShimmerAnimation
import com.example.deliveryapp.designs.TopAppBar
import com.example.deliveryapp.utils.TAG
import com.example.deliveryapp.utils.checkMinuteTextSinPul
import com.example.deliveryapp.utils.connection.ConnectionLiveData
import com.example.deliveryapp.utils.convertors.convertHTMLToString
import com.example.deliveryapp.viewmodels.RecipeFragmentViewModel

class RecipeFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipeViewModel = ViewModelProvider(this).get(RecipeFragmentViewModel::class.java)
        arguments?.getInt("recipeID")?.let { id ->

            recipeViewModel?.id?.value = id
            recipeViewModel?.getRecipeDetailInfo()
            recipeViewModel?.getRecommendedFoodsInfo()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {

            setContent {

                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                Scaffold(scaffoldState = scaffoldState) {
                    setAllOfWidgets()
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
    fun setAllOfWidgets() {

        Column(modifier = Modifier.fillMaxWidth()) {
            TopAppBar(
                title = "Recipe Detail",
                icon = painterResource(id = R.drawable.icon),
                isMenuOn = false,
                modifier = Modifier.fillMaxWidth()
            )

            if (recipeViewModel.loading.value) {

                RecipeItemShimmerAnimation(
                    modifier = Modifier.padding(10.dp),
                    isRecomCardOn = true // recommended container is here
                )

            } else {
                recipeViewModel?.let {

                    getRecipeInfo(viewModel = it)

                }
            }

        }

    }


    @Composable
    fun getRecipeInfo(viewModel: RecipeFragmentViewModel) {

        viewModel.detailReceipt?.value?.title?.let { title ->

            val imageURL = viewModel.detailReceipt!!.value?.image
            val recipeDescription = viewModel.detailReceipt!!.value?.summary
            val recipe = convertHTMLToString(recipeDescription!!)
            val time = checkMinuteTextSinPul(viewModel.detailReceipt!!.value?.readyInMinutes!!)
            val healthScore =
                "Score: ${viewModel.detailReceipt!!.value?.healthScore}"

            viewModel.recommendedFoods?.value?.results?.let { healthyFoodList ->

                RecipeDetail(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    foodImage = imageURL,
                    foodTitle = title,
                    foodDescription = recipe,
                    healthScore = healthScore,
                    readyTime = time,
                    list = healthyFoodList,
                    onCLickCard = { ID ->
                        val bundle = Bundle()
                        bundle.putInt("recID", ID)
                        findNavController().navigate(R.id.viewRecommendedFoodDetail, bundle)
                    }
                )

            }
        }

    }

}