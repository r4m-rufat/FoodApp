package com.example.deliveryapp.apis

import com.example.deliveryapp.models.ResultsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {

    @GET("complexSearch?")
    fun getFoodInformations(
        @Query("query") query: String,
        @Query("offset") offset: Int,
        @Query("apiKey") apiKey: String
    ): Call<List<ResultsItem>>

}