package com.example.aguas

import com.google.gson.Gson
/**
 *
 *
 *
 *
 * @autor Aitor
 * */

class Agua(
    val id: Int,
    val idEstacion: String,
    val estacion: String,
    val senal: String,
    val fecha: String,
    val valor: String
)

val aguaString="{'id':1, "+
        "'idEstacion':'aaaa', "+
        "'estacion':'bbbbbb', "+
        "'senal':'aaaa', "+
        "'fecha':'1111', "+
        "'senal':'aaaa', "+
        "'valor':'2134234234' }"
val gson = Gson()

val agua = gson.fromJson(
    aguaString,
    Agua::class.java

)