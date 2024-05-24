package com.example.aguas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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

        val favoritosButton = findViewById<Button>(R.id.cesta_button)
        favoritosButton.setOnClickListener {
            val intent = Intent(this, Favoritos::class.java)
            startActivity(intent)
        }
    }
}
