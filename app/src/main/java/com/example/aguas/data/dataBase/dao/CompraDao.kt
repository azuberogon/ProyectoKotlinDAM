package com.example.aguas.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aguas.data.dataBase.entity.Compras

/**
 * Interfaz DAO (Data Access Object) para la entidad Compras.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete) en la tabla 'compras_table' de la base de datos.
 */
@Dao
interface CompraDao {
    /**
     * Inserta un objeto Compras en la tabla 'compras_table'.
     *
     * @param compra El objeto Compras que se va a insertar.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(compra: Compras)

    /**
     * Obtiene todas las compras almacenadas en la tabla 'compras_table'.
     *
     * @return Una lista de objetos Compras.
     */
    @Query("SELECT * FROM compras_table")
    suspend fun getAllCompras(): List<Compras>
}
