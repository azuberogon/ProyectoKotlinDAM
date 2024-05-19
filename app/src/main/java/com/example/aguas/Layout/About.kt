package com.example.aguas.Layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aguas.R

/**
 * Actividad que muestra información acerca de la aplicación.
 * @autor Aitor
 */
class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Setea el texto del ScrollView con el texto de muestra del contrato
        val scrollViewText = findViewById<TextView>(R.id.loremimpsun)
        val loremIpsum = resources.getString(R.string.sample_contract_text)
        scrollViewText.text = loremIpsum
    }
}
