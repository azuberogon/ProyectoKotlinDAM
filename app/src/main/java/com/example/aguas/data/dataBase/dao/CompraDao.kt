package com.example.aguas.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aguas.data.dataBase.entity.Compras

@Dao
interface CompraDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(compra: Compras)

    @Query("SELECT * FROM compras_table")
    suspend fun getAllCompras(): List<Compras>
}
