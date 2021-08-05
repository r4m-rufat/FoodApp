package com.example.deliveryapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.deliveryapp.designs.*
import com.example.deliveryapp.designs.recipe_list_shimmer.ShimmerAnimation
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.utils.TAG
import com.example.deliveryapp.utils.connection.ConnectionLiveData
import com.example.deliveryapp.utils.recipe_list.getAllFoodCategoriesValue
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class RecipeListFragment : Fragment() {

    private lateinit var viewModelProvider: HomeActivityViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            setContent {

                DeliveryAppTheme {

                    getViewModels()
                    val scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()

                    Scaffold(scaffoldState = scaffoldState) {
                        setAllWidgets()
                        if (ConnectionLiveData.observeAsState(true).value) {
                            Log.d(TAG, "onCreateView: Connection comes")
                        } else {
                            Log.d(TAG, "onCreateView: Connection is lost")
                            ConnectionSnackbar(
                                modifier = Modifier.padding(horizontal = 5.dp),
                                scaffoldState = scaffoldState,
                                scope = scope
                            )
                        }

                    }

                }

            }
        }
    }

    private fun getViewModels() {

        viewModelProvider =
            ViewModelProvider(requireActivity()).get(HomeActivityViewModel::class.java)
        selectedCategoryViewModel =
            ViewModelProvider(requireActivity()).get(SelectedCategoryViewModel::class.java)
        viewModelProvider.query.value = selectedCategoryViewModel.selectedCategory.value

        ConnectionLiveData.init(requireContext())

    }

    @Composable
    private fun setAllWidgets() {

        Column(modifier = Modifier.fillMaxSize()) {

            TopAppBar(
                title = "Zardab Foods",
                icon = painterResource(id = R.drawable.icon),
                isMenuOn = true
            )

            TextFieldDesign(onClick = { text, _ ->
                viewModelProvider.query.value = text
                viewModelProvider.resetSearchState()
                selectedCategoryViewModel.selectedCategory.value = ""
            })
            Spacer(modifier = Modifier.height(5.dp))
            MenuList(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(),
                menuList = getAllFoodCategoriesValue(),
                selectedCategoryViewModel,
                homeViewModel = viewModelProvider
            )

            Spacer(modifier = Modifier.height(5.dp))

            val deliveryList = viewModelProvider.deliveryList.value

            val page = viewModelProvider.page.value

            if (viewModelProvider.loading.value) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {

                    /**
                     * Lazy column repeats ShimmerAnimation 5 times
                     */
                    LazyColumn() {
                        repeat(5) {
                            item {
                                ShimmerAnimation(
                                    modifier = Modifier.padding(bottom = 10.dp)
                                )
                            }
                        }
                    }

                }
            } else {
                deliveryList?.let { recipes ->
                    FoodList(
                        recipes = recipes,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        page = page,
                        viewModelProvider = viewModelProvider,
                        onCLickItem = { recipeID ->
                            val bundle = Bundle()
                            bundle.putInt("recipeID", recipeID)
                            findNavController().navigate(R.id.viewRecipeDetail, bundle)
                        }
                    )
                }
            }

        }

    }

}