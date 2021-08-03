package com.example.deliveryapp.repositories

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.foods.ComplexResponse
import com.example.deliveryapp.models.foods.ResultsItem
import com.example.deliveryapp.utils.API_KEY
import com.example.deliveryapp.utils.TAG
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDeliveryRepository {

    companion object Factory {
        var INSTANCE: HomeDeliveryRepository? = null
        fun instanceOf(): HomeDeliveryRepository? {
            if (INSTANCE == null) {
                INSTANCE = HomeDeliveryRepository()
            }
            return INSTANCE
        }

    }

    /**
     * we get the data from api and that's why
     * is used
     * @see IO Dispatcher
     */

     suspend fun setDeliveryData(deliveryData: MutableState<List<ResultsItem?>?>, query: String, offset: String, loading: MutableState<Boolean>) {
        withContext(IO) {
            deliveryDataSetup(deliveryData, query, offset, loading)
        }

    }

    private fun deliveryDataSetup(deliveryData: MutableState<List<ResultsItem?>?>, query: String, offset: String, loading: MutableState<Boolean>) {

        val apicall = ApiClient.getRetrofit()!!.create(IApi::class.java).getFoodInformations(query, offset, API_KEY)
        apicall.enqueue(object : Callback<ComplexResponse>{
            override fun onResponse(
                call: Call<ComplexResponse>,
                response: Response<ComplexResponse>
            ) {
                if (response.isSuccessful){
                    deliveryData.value =response.body()!!.results
                    Thread.sleep(2000L) // just show the shimmer animation because api is so fast
                    loading.value = false
                    Log.d(TAG, "onResponse: Delivery list successfully comes")
                }
            }

            override fun onFailure(call: Call<ComplexResponse>, t: Throwable) {
                deliveryData.value = null
                loading.value = true
                Log.d(TAG, "onFailure: Delivery list doesn't come")
            }


        })

    }

}