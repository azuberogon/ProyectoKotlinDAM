package com.example.aguas.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aguas.data.dataBase.dao.CatDao
import com.example.aguas.data.dataBase.dao.CompraDao
import com.example.aguas.data.dataBase.entity.Cat
import com.example.aguas.data.dataBase.entity.Compras

@Database(entities = [Cat::class, Compras::class], version = 1, exportSchema = false)
abstract class CatDatabase : RoomDatabase() {

    abstract fun catDao(): CatDao
    abstract fun compraDao(): CompraDao

    companion object {
        @Volatile
        private var INSTANCE: CatDatabase? = null

        fun getDatabase(context: Context): CatDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatDatabase::class.java,
                    "cat_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
