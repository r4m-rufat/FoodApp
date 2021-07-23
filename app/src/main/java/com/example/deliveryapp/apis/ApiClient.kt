package com.example.deliveryapp.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private var retrofit: Retrofit? =  null
    private val BASE_URL: String = ""

    fun getRetrofit(): Retrofit? {

        if (retrofit == null){

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        return retrofit

    }


}