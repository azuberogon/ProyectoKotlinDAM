package com.example.aguas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Registro : AppCompatActivity() {
    private lateinit var btnSiguiente: Button
    private lateinit var btnCancelar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)



        btnSiguiente = findViewById(R.id.btnSiguiente)


        btnSiguiente.setOnClickListener{
            val intent = Intent(this@Registro, menu::class.java )
            startActivity(intent)
            finish()
        }

        btnCancelar = findViewById(R.id.btnCancelar)

        btnCancelar.setOnClickListener{
            finish()
            val intent = Intent(this@Registro, MainActivity::class.java )
            startActivity(intent)

        }
    }
}