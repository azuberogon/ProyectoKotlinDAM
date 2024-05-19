package com.example.aguas.data.dataBase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class Cat(
    @PrimaryKey val id: String,
    val url: String,
    val name: String,
    val age: Int,
    val gender: String,
    val premium:Boolean
)
