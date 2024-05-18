package com.example.aguas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * Actividad de registro que permite al usuario proceder o cancelar el registro.
 *
 * @constructor Crea una instancia de `Registro`.
 * @property btnSiguiente Botón que navega a la actividad del menú.
 * @property btnCancelar Botón que cancela el registro y navega a la actividad principal.
 * @see AppCompatActivity
 * @since 1.0
 *
 * @sample
 * ```kotlin
 * class Registro : AppCompatActivity() {
 *     private lateinit var btnSiguiente: Button
 *     private lateinit var btnCancelar: Button
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *         setContentView(R.layout.activity_registro)
 *
 *         btnSiguiente = findViewById(R.id.btnSiguiente)
 *
 *         btnSiguiente.setOnClickListener {
 *             val intent = Intent(this@Registro, menu::class.java)
 *             startActivity(intent)
 *             finish()
 *         }
 *
 *         btnCancelar = findViewById(R.id.btnCancelar)
 *
 *         btnCancelar.setOnClickListener {
 *             finish()
 *             val intent = Intent(this@Registro, MainActivity::class.java)
 *             startActivity(intent)
 *         }
 *     }
 * }
 * ```
 *
 * @autor Aitor
 */
class Registro : AppCompatActivity() {
    private lateinit var btnSiguiente: Button
    private lateinit var btnCancelar: Button

    /**
     * Método de callback que se llama cuando la actividad es creada.
     *
     * @param savedInstanceState Instancia de estado de la actividad previamente guardada, si la hay.
     * @throws NullPointerException Si algún botón no se encuentra en el layout.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSiguiente.setOnClickListener {
            val intent = Intent(this@Registro, menu::class.java)
            startActivity(intent)
            finish()
        }

        btnCancelar = findViewById(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            finish()
            val intent = Intent(this@Registro, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
