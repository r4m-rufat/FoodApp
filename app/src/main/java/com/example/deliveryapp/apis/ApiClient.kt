package com.example.deliveryapp.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? =  null
    private val BASE_URL: String = "https://api.spoonacular.com/recipes/"

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