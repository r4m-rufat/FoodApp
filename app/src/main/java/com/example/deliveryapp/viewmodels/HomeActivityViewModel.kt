package com.example.deliveryapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.foods.ComplexResponse
import com.example.deliveryapp.models.foods.ResultsItem
import com.example.deliveryapp.repositories.HomeDeliveryRepository
import com.example.deliveryapp.utils.API_KEY
import com.example.deliveryapp.utils.PAGE_SIZE
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivityViewModel : ViewModel() {
    private val TAG = "HomeActivityViewModel"
    var deliveryList: MutableState<List<ResultsItem?>?> = mutableStateOf(listOf())
    val page = mutableStateOf(0)
    private var listScrollPosition = 0
    val query = mutableStateOf("")
    val scrollPositionInSearch = mutableStateOf(false)

    init {
        getRecipeList(query.value)
    }

    private fun incrementPageNumber(){
        page.value+=1
    }

    fun onChangeScrollPosition(position: Int){
        listScrollPosition = position
    }

    /**
     * add new recipes to recipe list
     * @see deliveryList
     */
    private fun appendRecipesToRecipeList(recipes: List<ResultsItem?>?){

        val currentList = ArrayList(deliveryList.value)
        recipes?.let {recipes ->
            currentList.addAll(recipes)
        }
        deliveryList.value = currentList

    }

    fun nextRecipePage(){

        scrollPositionInSearch.value = false
        viewModelScope.launch {

            if ((listScrollPosition + 1) >= (page.value * PAGE_SIZE)){
                incrementPageNumber()
                Log.d(TAG, "nextRecipePage: Next page value is ${page.value}")

                if (page.value > 1){
                    val apicall = ApiClient.getRetrofit()!!.create(IApi::class.java).getFoodInformations(query = query.value, page.value.toString(), API_KEY)
                    apicall.enqueue(object : Callback<ComplexResponse> {
                        override fun onResponse(
                            call: Call<ComplexResponse>,
                            response: Response<ComplexResponse>
                        ) {
                            if (response.isSuccessful){
                                appendRecipesToRecipeList(response.body()!!.results)
                                Log.d(TAG, "onResponse: Delivery list successfully comes")
                            }
                        }

                        override fun onFailure(call: Call<ComplexResponse>, t: Throwable) {
                            appendRecipesToRecipeList(recipes = null)
                            Log.d(TAG, "onFailure: Recipes doesn't load. Reason: \n${t.message}")
                        }

                    })
                }

            }

        }

    }

    fun resetSearchState(){

        scrollPositionInSearch.value = true
        page.value = 0
        onChangeScrollPosition(0)
        getRecipeList(query.value)

    }

    private fun getRecipeList(query: String){
        viewModelScope.launch {
            HomeDeliveryRepository.instanceOf()!!
                .setDeliveryData(deliveryList, query = query, page.value.toString())
        }
    }

    fun onCategorySelected(category: String){

        scrollPositionInSearch.value = true
        page.value = 0
        onChangeScrollPosition(0)
        getRecipeList(category)

    }

}