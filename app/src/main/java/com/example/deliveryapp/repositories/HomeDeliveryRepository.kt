package com.example.deliveryapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.models.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDeliveryRepository {

    private val TAG = "HomeDeliveryRepository"
    var deliveryList: List<ResultsItem> = ArrayList()

    companion object Factory{
        var INSTANCE: HomeDeliveryRepository? = null
        fun instanceOf(): HomeDeliveryRepository? {
            if (INSTANCE != null){
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

    suspend fun getDeliveryData(): MutableLiveData<List<ResultsItem>>{
        val  deliveryData: MutableLiveData<List<ResultsItem>> = MutableLiveData()
        var deliveryJob = CoroutineScope(IO).launch {
            val api: IApi = ApiClient().getRetrofit()!!.create(IApi::class.java)
            val apiCall: Call<List<ResultsItem>> = api.getFoodInformations("pasta", 0, "64fb3e15382e4e9392adde24f23e0e9a")
            setDeliveryData(apiCall)
            deliveryData.value = deliveryList
        }
        deliveryJob.join()
        return deliveryData
    }

    /**
     * set delivery data to "deliveryList" with enqueue
     */
    fun setDeliveryData(apiCall: Call<List<ResultsItem>>){

        apiCall.enqueue(object : Callback<List<ResultsItem>>{
            override fun onResponse(
                call: Call<List<ResultsItem>>,
                response: Response<List<ResultsItem>>
            ) {
                if (response.isSuccessful){
                    deliveryList = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<ResultsItem>>, t: Throwable) {
                Log.d(TAG, "onFailure: List doesn't come")
            }

        })

    }

}