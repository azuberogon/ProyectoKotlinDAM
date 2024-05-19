package com.example.aguas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/**
 * Actividad que muestra la cesta de la compra.
 *
 * Esta actividad se encarga de mostrar los productos seleccionados por el usuario para comprar.
 *
 * @constructor Crea una instancia de `cestaDeLaCompra`.
 * @see AppCompatActivity
 * @since 1.0
 * @autor Aitor
 */
class cestaDeLaCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta_de_la_compra)
    }
}
