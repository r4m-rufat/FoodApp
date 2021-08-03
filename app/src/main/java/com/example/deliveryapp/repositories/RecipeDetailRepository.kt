package com.example.deliveryapp.repositories

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.receipes.RecipeResponse
import com.example.deliveryapp.utils.API_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeDetailRepository {

    private val TAG = "RecipeDetailRepository"

    companion object {
        var INSTANCE: RecipeDetailRepository? = null

        fun instanceOf(): RecipeDetailRepository? {
            if (INSTANCE == null) {
                INSTANCE = RecipeDetailRepository()
            }
            return INSTANCE
        }

    }

    fun getRecipeInformation(recipeData: MutableState<RecipeResponse?>, id: Int, loading: MutableState<Boolean>){

        recipeData.value = null // because data must refresh

        CoroutineScope(IO).launch {
            val apiCall = ApiClient.getRetrofit()!!.create(IApi::class.java)!!.getRecipeInformation(id = id, boolean = false, API_KEY)

            apiCall.enqueue(object : Callback<RecipeResponse>{
                override fun onResponse(
                    call: Call<RecipeResponse>,
                    response: Response<RecipeResponse>
                ) {

                    if (response.isSuccessful){
                        recipeData.value = response.body()!!
                        Log.d(TAG, "onResponse: Recipe successfully comes")

                    }

                    Log.d(TAG, "onResponse: ${response.code()}")

                }

                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                    recipeData.value = null
                    loading.value = true
                    Log.d(TAG, "onFailure: Recipe information doesn't come. Reason:\n${t.message}")
                }

            })

            delay(2000L)
            loading.value = false

        }

    }

}