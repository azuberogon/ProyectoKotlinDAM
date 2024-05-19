package com.example.aguas.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ApiGatos {

    interface CatApiService {
        @GET("images/search")
        fun getRandomCats(@Query("limit") limit: Int): Call<List<TheCat>>
    }

    object RetrofitClient {
        private const val BASE_URL = "https://api.thecatapi.com/v1/"

        val instance: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


    }
}