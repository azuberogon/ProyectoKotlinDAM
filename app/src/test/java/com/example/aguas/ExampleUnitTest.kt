package com.example.aguas

import org.junit.Test

import org.junit.Assert.*
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}



class UsuarioTest {

    @Test
    fun validarUsuario_credencialesCorrectas() {
        val usuario = Usuario("juan123", "segura123")
        assertTrue(validarUsuario(usuario, "juan123", "segura123"))
    }

    @Test
    fun validarUsuario_credencialesIncorrectas() {
        val usuario = Usuario("juan123", "segura123")
        assertFalse(validarUsuario(usuario, "juan123", "incorrecta"))
    }

    private fun validarUsuario(usuario: Usuario, nombreUsuario: String, contrasena: String): Boolean {
        return usuario.nombreUsuario == nombreUsuario && usuario.contrasena == contrasena
    }
}
