package com.example.aguas.data.dataBase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "compras_table")
data class Compras(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val catId: String,
    val foodType: String
)