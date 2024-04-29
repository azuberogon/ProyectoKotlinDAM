package com.example.aguas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnSiguiente: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener{
            val intent = Intent(this@MainActivity, menu::class.java )
            startActivity(intent)
        }
    }
}