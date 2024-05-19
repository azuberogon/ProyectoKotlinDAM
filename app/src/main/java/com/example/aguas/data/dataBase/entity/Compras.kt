package com.example.aguas.data.dataBase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de entidad que representa la tabla 'compras_table' en la base de datos.
 * Contiene los detalles de una compra, como su ID (auto generado), ID del gato y el tipo de comida comprada.
 */
@Entity(tableName = "compras_table")
data class Compras(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val catId: String,
    val foodType: String
)
