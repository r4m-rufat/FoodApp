package com.example.deliveryapp.repositories

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.ComplexResponse
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.utils.API_KEY
import com.example.deliveryapp.utils.TAG
import kotlinx.coroutines.Dispatchers.IO
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

     suspend fun setDeliveryData(deliveryData: MutableState<List<ResultsItem?>?>,  query: String, offset: String) {
        withContext(IO) {
            deliveryDataSetup(deliveryData, query, offset)
        }

    }

    private fun deliveryDataSetup(deliveryData: MutableState<List<ResultsItem?>?>, query: String, offset: String) {

        val apicall = ApiClient.getRetrofit()!!.create(IApi::class.java).getFoodInformations(query, offset, API_KEY)
        apicall.enqueue(object : Callback<ComplexResponse>{
            override fun onResponse(
                call: Call<ComplexResponse>,
                response: Response<ComplexResponse>
            ) {
                if (response.isSuccessful){
                    deliveryData.value =response.body()!!.results
                }
                Log.d(TAG, "onResponse: Delivery list successfully comes")
            }

            override fun onFailure(call: Call<ComplexResponse>, t: Throwable) {
                deliveryData.value = null
                Log.d(TAG, "onFailure: Delivery list doesn't come")
            }


        })
    }

}