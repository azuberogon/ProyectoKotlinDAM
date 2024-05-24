package com.example.aguas.data.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de entidad que representa la tabla 'cat_table' en la base de datos.
 * Contiene los detalles de un gato, como su ID, URL de imagen, nombre, edad, género y si es premium o no.
 */
/*
data class Cat(
    @PrimaryKey val id: String,
    val url: String,
    val name: String,
    val age: Int,
    val gender: String,
    val heart: Int
)*/
@Entity(tableName = "Gatos")
data class Cat(
    @PrimaryKey(autoGenerate = true) val Cid: Int,
    @ColumnInfo("imagen") val url: String,
    @ColumnInfo("nombreGato") val nombre: String?,
    @ColumnInfo("edad del gato")val edad : Int?,
    @ColumnInfo("genero del gato") val genero : String?,
    @ColumnInfo("corazon") val corazon : Boolean
)