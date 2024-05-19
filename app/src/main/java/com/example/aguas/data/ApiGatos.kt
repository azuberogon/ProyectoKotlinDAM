package com.example.aguas.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Class que proporciona una interfaz para consumir la API de TheCat.
 */
class ApiGatos {

    /**
     * Interfaz Retrofit para definir los endpoints de la API de TheCat.
     */
    interface CatApiService {
        @GET("images/search")
        fun getRandomCats(@Query("limit") limit: Int): Call<List<TheCat>>
    }

    /**
     * Objeto RetrofitClient que proporciona una instancia de Retrofit para realizar las llamadas a la API.
     */
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
