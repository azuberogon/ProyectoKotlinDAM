package com.example.elclubdelalectura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar


class Menu_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val toolbar: Toolbar = findViewById(R.id. toolbar)
        setSupportActionBar(toolbar)

    }
}