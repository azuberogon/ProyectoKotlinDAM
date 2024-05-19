package com.example.aguas.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/*
 *
 *
 *
 *
 * @autor Aitor
 * */
/**
 * Interfaz que define los endpoints de la API de películas.
 */
interface RetrofitService {
    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(

    )
}



