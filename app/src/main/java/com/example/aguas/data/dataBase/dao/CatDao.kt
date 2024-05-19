package com.example.aguas.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aguas.data.dataBase.entity.Cat

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cat: Cat)

    @Query("SELECT * FROM cat_table")
    suspend fun getAllCats(): List<Cat>
}
