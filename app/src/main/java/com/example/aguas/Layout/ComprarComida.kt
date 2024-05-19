package com.example.aguas.Layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aguas.R
import com.example.aguas.cestaDeLaCompra
import com.example.aguas.data.dataBase.CatDatabase
import com.example.aguas.data.dataBase.entity.Cat
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class ComprarComida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_comida)

        val imageView: ImageView = findViewById(R.id.detail_cat_image)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)
        val txtNombre: TextView = findViewById(R.id.txtNombre)
        val txtEdad: TextView = findViewById(R.id.txtEdad)
        val txtGenero: TextView = findViewById(R.id.txtGenero)
        val checkComidaPremium: CheckBox = findViewById(R.id.checkBoxComidaPremium)

        val imageUrl = intent.getStringExtra("IMAGE_URL")
        val catId = intent.getStringExtra("CAT_ID")

        if (imageUrl != null) {
            Picasso.get().load(imageUrl).into(imageView)
        }

        btnGuardar.setOnClickListener {
            if (catId != null && imageUrl != null) {
                val name = txtNombre.text.toString()
                val age = txtEdad.text.toString().toInt()
                val gender = txtGenero.text.toString()
                val premium = checkComidaPremium.isChecked

                val cat = Cat(catId, imageUrl, name, age, gender, premium)
                saveCatToDatabase(cat)
            }
            val intent = Intent(this, cestaDeLaCompra::class.java)
            startActivity(intent)
        }

        btnCancelar.setOnClickListener {
            finish()  // This will destroy the current activity and return to the previous one
        }
    }

    private fun saveCatToDatabase(cat: Cat) {
        val catDao = CatDatabase.getDatabase(application).catDao()
        lifecycleScope.launch {
            catDao.insert(cat)
            runOnUiThread {
                Toast.makeText(this@ComprarComida, "Gracias por tu compra", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
