package com.example.aguas.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aguas.data.dataBase.entity.Cat


/**
 * Interfaz DAO (Data Access Object) para la entidad Cat.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete) en la tabla 'cat_table' de la base de datos.
 */
@Dao
interface CatDao {
    /**
     * Inserta un objeto Cat en la tabla 'cat_table'.
     *
     * @param cat El objeto Cat que se va a insertar.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cat: Cat)

    /**
     * Obtiene todos los objetos Cat almacenados en la tabla 'cat_table'.
     *
     * @return Una lista de objetos Cat.
     */
    @Query("SELECT * FROM Gatos")
    suspend fun getAllCats(): List<Cat>



    @Query("SELECT * FROM Gatos")
    fun getAll(): List<Cat>
/*
    @Query("SELECT * FROM tablaDeGatos WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Cat>
*/
    @Query("SELECT * FROM Gatos WHERE corazon =:corrazon")
    fun getFavoritos(corrazon: Boolean): List<Cat>
    @Insert
    fun insertAll(vararg users: Cat)

    @Delete
    fun delete(cat: Cat)

}
