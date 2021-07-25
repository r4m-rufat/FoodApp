package com.example.deliveryapp.apis

import com.example.deliveryapp.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? =  null

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