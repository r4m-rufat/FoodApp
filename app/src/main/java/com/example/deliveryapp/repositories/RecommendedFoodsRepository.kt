package com.example.deliveryapp.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.recommended_foods.RecommendedResponse
import com.example.deliveryapp.utils.API_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecommendedFoodsRepository {

    private val TAG = "RecommendedFoodsRepository"
    private val query: String = "Healthy"

    companion object{
        var INSTANCE: RecommendedFoodsRepository? = null
        fun instanceOf(): RecommendedFoodsRepository? {
            if (INSTANCE == null){
                INSTANCE = RecommendedFoodsRepository()
            }

            return INSTANCE

        }

    }

    fun getRecommendsFoodsData(recommededList: MutableState<RecommendedResponse?>){

        recommededList.value = null

        CoroutineScope(IO).launch {

            val apiCall = ApiClient.getRetrofit()?.create(IApi::class.java)?.getRecommendedFoods(query = query, 1, 20, API_KEY)

            apiCall?.enqueue(object : Callback<RecommendedResponse> {
                @SuppressLint("LongLogTag")
                override fun onResponse(
                    call: Call<RecommendedResponse?>,
                    response: Response<RecommendedResponse?>
                ) {
                    if (response.isSuccessful){
                        recommededList.value = response.body()
                        Log.d(TAG, "onResponse: Healthy foods successfully comes")
                        Log.d(TAG, "onResponse: Item -> ${response.body()?.results?.get(0)?.image}")
                    }
                }

                @SuppressLint("LongLogTag")
                override fun onFailure(call: Call<RecommendedResponse?>, t: Throwable) {
                    Log.d(TAG, "onFailure: Data doesn't come. Reason: ${t.message}")
                }

            })

        }

    }

}