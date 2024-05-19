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

/**
 * Actividad que permite al usuario comprar comida para un gato y guardar la información en la base de datos.
 */
class ComprarComida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_comida)

        // Inicialización de las vistas
        val imageView: ImageView = findViewById(R.id.detail_cat_image)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)
        val txtNombre: TextView = findViewById(R.id.txtNombre)
        val txtEdad: TextView = findViewById(R.id.txtEdad)
        val txtGenero: TextView = findViewById(R.id.txtGenero)
        val checkComidaPremium: CheckBox = findViewById(R.id.checkBoxComidaPremium)

        // Obtención de la URL de la imagen del gato y su ID de la intención
        val imageUrl = intent.getStringExtra("IMAGE_URL")
        val catId = intent.getStringExtra("CAT_ID")

        // Cargar la imagen del gato si la URL no es nula
        if (imageUrl != null) {
            Picasso.get().load(imageUrl).into(imageView)
        }

        // Listener del botón de guardar
        btnGuardar.setOnClickListener {
            // Verificar que el ID y la URL del gato no son nulos
            if (catId != null && imageUrl != null) {
                // Obtener el nombre, edad, género y si la comida es premium del usuario
                val name = txtNombre.text.toString()
                val age = txtEdad.text.toString().toInt()
                val gender = txtGenero.text.toString()
                val premium = checkComidaPremium.isChecked

                // Crear un objeto Cat con la información proporcionada
                val cat = Cat(catId, imageUrl, name, age, gender, premium)

                // Guardar el gato en la base de datos
                saveCatToDatabase(cat)
            }

            // Iniciar la actividad de la cesta de la compra después de guardar el gato
            val intent = Intent(this, cestaDeLaCompra::class.java)
            startActivity(intent)
        }

        // Listener del botón de cancelar
        btnCancelar.setOnClickListener {
            finish()  // Finalizar la actividad actual y volver a la anterior
        }






    }

    /**
     * Guarda la información del gato en la base de datos.
     * @param cat El objeto Cat que se va a guardar.
     */
    private fun saveCatToDatabase(cat: Cat) {
        val catDao = CatDatabase.getDatabase(application).catDao()
        lifecycleScope.launch {
            catDao.insert(cat)
            runOnUiThread {
                Toast.makeText(this@ComprarComida, "¡Gracias por tu compra!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
