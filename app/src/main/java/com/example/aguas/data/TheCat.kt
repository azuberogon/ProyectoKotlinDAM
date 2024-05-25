package com.example.aguas.data

import androidx.room.Entity

/**
 * Data class que representa un objeto Cat obtenido de la API.
 */
@Entity
data class TheCat(
    val id: String,
    val url: String
)
