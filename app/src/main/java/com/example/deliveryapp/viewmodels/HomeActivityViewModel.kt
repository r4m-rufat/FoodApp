package com.example.deliveryapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.ComplexResponse
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.repositories.HomeDeliveryRepository
import com.example.deliveryapp.utils.PAGE_SIZE
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.FieldPosition


class HomeActivityViewModel : ViewModel() {
    private val TAG = "HomeActivityViewModel"
    var deliveryList: MutableState<List<ResultsItem?>?> = mutableStateOf(listOf())
    val page = mutableStateOf(0)
    private var listScrollPosition = 0

    init {
        viewModelScope.launch {
            HomeDeliveryRepository.instanceOf()!!
                .setDeliveryData(deliveryList, "pasta", page.value.toString())
        }
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
        currentList.addAll(recipes!!)
        deliveryList.value = currentList

    }

    fun nextRecipePage(){

        viewModelScope.launch {

            if ((listScrollPosition + 1) >= (page.value * PAGE_SIZE)){
                incrementPageNumber()
                Log.d(TAG, "nextRecipePage: Next page value is ${page.value}")

                if (page.value > 1){
                    val apicall = ApiClient.getRetrofit()!!.create(IApi::class.java).getFoodInformations("pasta", page.value.toString(), "64fb3e15382e4e9392adde24f23e0e9a")
                    apicall.enqueue(object : Callback<ComplexResponse> {
                        override fun onResponse(
                            call: Call<ComplexResponse>,
                            response: Response<ComplexResponse>
                        ) {
                            if (response.isSuccessful){
                                appendRecipesToRecipeList(response.body()!!.results)
                            }
                            Log.d(TAG, "onResponse: Delivery list successfully comes")
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

}