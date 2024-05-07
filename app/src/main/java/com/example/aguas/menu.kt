package com.example.aguas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val recycler: RecyclerView =
            findViewById(R.id. recycler)
        recycler.adapter = Adapter(
            listOf(
                Datos( "Azul", "#2196F3"),
                Datos( "Rojo", "#2196F3"),
                Datos( "Naranja", "#2196F3"),
                Datos( "Azul", "#2196F3"),
                Datos( "Rojo", "#2196F3"),
                Datos( "Naranja", "#2196F3")
            )
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)




    }

    override fun onOptionsItemSelected (item: MenuItem): Boolean {
        if (item.itemId == R.id.ajustes_action) {
            Toast.makeText( this, "ajustes",
                Toast.LENGTH_SHORT).show()
        }else if (item.itemId == R.id.registrarse_action) {
            Toast.makeText( this, "registrarse",
                Toast.LENGTH_SHORT).show()
        }else if (item.itemId == R.id.inicioSesion_action) {
            Toast.makeText( this, "inicio de sesion",
                Toast.LENGTH_SHORT).show()
        }else if (item.itemId == R.id.about_action) {
            Toast.makeText( this, "about",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }
    private fun buildColors (): List<Datos> {
        return listOf(
            Datos(getString(R.string.red), getColorHex(R.color.red)),
            Datos(getString(R.string.indigo), getColorHex(R.color.indigo)),
            Datos(getString(R.string.green), getColorHex(R.color.green)),
            Datos(getString(R.string.orange), getColorHex(R.color.orange)),
            Datos(getString(R.string.blue), getColorHex(R.color.blue)),
            Datos(getString(R.string.yellow), getColorHex(R.color.yellow)),
            Datos(getString(R.string.bluegrey), getColorHex(R.color.bluegrey)),
            Datos(getString(R.string.teal), getColorHex(R.color.teal)),
            Datos(getString(R.string.deeppurple), getColorHex(R.color.deeppurple)),
            Datos(getString(R.string.cyan), getColorHex(R.color.cyan)),
            Datos(getString(R.string.brown), getColorHex(R.color.brown))
        )
    }
    private fun getColorHex (colorResId: Int): String {
        return String.format("#%06X", 0xFFFFFF and ContextCompat.getColor( this, colorResId))
    }





























}

