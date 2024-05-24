package com.example.aguas.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aguas.data.dataBase.dao.CatDao
import com.example.aguas.data.dataBase.entity.Cat

/**
 * Base de datos Room que contiene las tablas de 'Cat' y 'Compras'.
 */
@Database(entities = [Cat::class], version = 1)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun catDao(): CatDao

    companion object{
        private const val DATABASE_NAME = "CAT.DB"

        @Volatile
        private  var INSTANCE: LocalDataBase? = null
        fun  getInstance(context:Context): LocalDataBase {
            synchronized(this){
                var instance= INSTANCE
                if(instance == null){
                    //abrir conexion
                    instance = Room.databaseBuilder(context.applicationContext, LocalDataBase::class.java,DATABASE_NAME).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
