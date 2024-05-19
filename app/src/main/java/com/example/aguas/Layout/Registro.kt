package com.example.aguas.Layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aguas.R
/**
 * Actividad de registro que permite al usuario proceder con el registro o cancelarlo.
 *
 * Esta actividad proporciona dos botones: uno para continuar con el registro y navegar a la actividad del menú, y otro para cancelar el registro y volver a la actividad principal.
 *
 * @constructor Crea una instancia de `Registro`.
 * @property btnSiguiente Botón que navega a la actividad del menú.
 * @property btnCancelar Botón que cancela el registro y navega a la actividad principal.
 * @see AppCompatActivity
 * @since 1.0
 * @autor Aitor
 */
class Registro : AppCompatActivity() {
    private lateinit var btnSiguiente: Button
    private lateinit var btnCancelar: Button

    /**
     * Método de callback que se llama cuando la actividad es creada.
     *
     * Configura los listeners de los botones y maneja sus acciones.
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
