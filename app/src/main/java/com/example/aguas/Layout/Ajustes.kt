package com.example.aguas.Layout

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import com.example.aguas.R

/**
 *
 *
 *
 *
 * @autor Aitor
 * */
class Ajustes : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switchModoOscuro: Switch
    private val PREFS_NAME = "theme_prefs"
    private val KEY_THEME = "current_theme"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        // Aplicar el tema antes de setContentView
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isDarkTheme = sharedPreferences.getBoolean(KEY_THEME, false)
        setAppTheme(isDarkTheme)

        setContentView(R.layout.activity_ajustes)

        switchModoOscuro = findViewById(R.id.switchModoOscuro)
        switchModoOscuro.isChecked = isDarkTheme

        switchModoOscuro.setOnCheckedChangeListener { _, isChecked ->
            // Guardar la preferencia del tema
            sharedPreferences.edit().putBoolean(KEY_THEME, isChecked).apply()
            // Recargar la actividad para aplicar el tema
            recreate()
        }
    }
    private fun setAppTheme(isDarkTheme: Boolean) {
        if (isDarkTheme) {
            setTheme(R.style.AppTheme)
        } else {
            setTheme(R.style.AppThemeDark)
        }
    }
}