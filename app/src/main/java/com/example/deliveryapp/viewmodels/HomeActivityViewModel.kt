package com.example.deliveryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.repositories.HomeDeliveryRepository

class HomeActivityViewModel : ViewModel() {

    lateinit var deliveryList: MutableLiveData<List<ResultsItem>>


    suspend fun init() {
        if (deliveryList == null) {
            deliveryList = HomeDeliveryRepository.instanceOf()!!.getDeliveryData()
        }
    }

    fun getDeliveryList(): LiveData<List<ResultsItem>> {
        return deliveryList
    }

}