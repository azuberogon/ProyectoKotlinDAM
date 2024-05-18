package com.example.aguas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

data class Usuario(
    val nombreUsuario: String,
    val contrasena: String
)

class verificacion : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etContrasena: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsuario = findViewById(R.id.editTxtNombreUsuario)
        etContrasena = findViewById(R.id.editTxtContraseña)
        btnLogin = findViewById(R.id.btnSiguiente)

        btnLogin.setOnClickListener {
            val usuarioIngresado = etUsuario.text.toString()
            val contrasenaIngresada = etContrasena.text.toString()

            val usuario = Usuario(nombreUsuario = "root", contrasena = "root")

            if (validarUsuario(usuario, usuarioIngresado, contrasenaIngresada)) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                // Navegar a otra actividad si el inicio de sesión es exitoso
            } else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarUsuario(usuario: Usuario, nombreUsuario: String, contrasena: String): Boolean {
        return usuario.nombreUsuario == nombreUsuario && usuario.contrasena == contrasena
    }
}
