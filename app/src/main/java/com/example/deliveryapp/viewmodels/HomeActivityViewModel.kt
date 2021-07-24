package com.example.deliveryapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.repositories.HomeDeliveryRepository
import kotlinx.coroutines.launch

class HomeActivityViewModel : ViewModel() {
    private val TAG = "HomeActivityViewModel"
    var deliveryList: MutableState<List<ResultsItem?>?> = mutableStateOf(listOf())


    init {
        viewModelScope.launch {
            HomeDeliveryRepository.instanceOf()!!
                .setDeliveryData(deliveryList)
        }
    }

}