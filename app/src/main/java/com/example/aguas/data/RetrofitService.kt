package com.example.aguas.data

import retrofit2.http.GET

interface RetrofitService {
//falta una url por meter en la cual es la base de https://developer.themoviedb.org/3 o algo asi tienes que mirarlo
    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(

    )

}