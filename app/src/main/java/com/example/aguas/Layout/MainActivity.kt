package com.example.aguas.Layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.aguas.R

/**
 *
 *
 *
 * Actividad principal de la aplicación que gestiona las acciones de los botones para navegar a otras actividades.
 *
 * @constructor Crea una instancia de `MainActivity`.
 * @property btnSiguiente Botón que navega a la actividad del menú.
 * @property btnRegistrar Botón que navega a la actividad de registro.
 * @see AppCompatActivity
 * @since 1.0
 *
 *
 * @author Aitor
 */
class MainActivity : AppCompatActivity() {/*


    /**
     * Método de callback que se llama cuando la actividad es creada.
     *
     * @param savedInstanceState Instancia de estado de la actividad previamente guardada, si la hay.
     * @throws NullPointerException Si algún botón no se encuentra en el layout.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSiguiente.setOnClickListener {
            val intent = Intent(this@MainActivity, menu::class.java)
            startActivity(intent)
        }

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            val intent = Intent(this@MainActivity, Registro::class.java)
            startActivity(intent)
        }
    }*/


    data class Usuario(
        val nombreUsuario: String,
        val contrasena: String
    )



        private lateinit var etUsuario: EditText
        private lateinit var etContrasena: EditText
        private lateinit var btnSiguiente: Button
        private lateinit var btnRegistrar: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            etUsuario = findViewById(R.id.editTxtNombreUsuario)
            etContrasena = findViewById(R.id.editTxtContraseña)
            btnSiguiente = findViewById(R.id.btnSiguiente)

            btnSiguiente.setOnClickListener {
                val usuarioIngresado = etUsuario.text.toString()
                val contrasenaIngresada = etContrasena.text.toString()

                val usuario = Usuario(nombreUsuario = "root", contrasena = "root")
                btnRegistrar = findViewById(R.id.btnRegistrar)
                btnRegistrar.setOnClickListener {
                    val intent = Intent(this@MainActivity, Registro::class.java)
                    startActivity(intent)
                }
                if (validarUsuario(usuario, usuarioIngresado, contrasenaIngresada)) {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    // Navegar a otra actividad si el inicio de sesión es exitoso
                    val intent = Intent(this@MainActivity, menu::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Nombre de usuario o contraseña incorrectos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        private fun validarUsuario(
            usuario: Usuario,
            nombreUsuario: String,
            contrasena: String
        ): Boolean {
            return usuario.nombreUsuario == nombreUsuario && usuario.contrasena == contrasena
        }



}