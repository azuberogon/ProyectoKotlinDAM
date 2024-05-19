package com.example.aguas.data.dataBase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de entidad que representa la tabla 'cat_table' en la base de datos.
 * Contiene los detalles de un gato, como su ID, URL de imagen, nombre, edad, género y si es premium o no.
 */
@Entity(tableName = "cat_table")
data class Cat(
    @PrimaryKey val id: String,
    val url: String,
    val name: String,
    val age: Int,
    val gender: String,
    val premium: Boolean
)
