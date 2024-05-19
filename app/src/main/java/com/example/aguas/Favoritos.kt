package com.example.aguas

import CatAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.Layout.About
import com.example.aguas.Layout.Ajustes
import com.example.aguas.Layout.ComprarComida
import com.example.aguas.Layout.Datos
import com.example.aguas.Layout.MainActivity
import com.example.aguas.Layout.Registro
import com.example.aguas.data.ApiGatos
import com.example.aguas.data.TheCat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Actividad que muestra los gatos favoritos del usuario.
 *
 * Esta actividad se encarga de mostrar los gatos favoritos seleccionados por el usuario.
 *
 * @constructor Crea una instancia de `Favoritos`.
 * @see AppCompatActivity
 * @since 1.0
 */
class Favoritos : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCatImages()
    }

    /**
     * Método que solicita imágenes de gatos aleatorios desde la API y las muestra en el RecyclerView.
     */
    private fun fetchCatImages() {
        val apiService = ApiGatos.RetrofitClient.instance.create(ApiGatos.CatApiService::class.java)
        apiService.getRandomCats(20).enqueue(object : Callback<List<TheCat>> {
            override fun onResponse(call: Call<List<TheCat>>, response: Response<List<TheCat>>) {
                if (response.isSuccessful) {
                    val catImages = response.body()!!
                    catAdapter = CatAdapter(catImages) { catImage ->
                        val intent = Intent(this@Favoritos, ComprarComida::class.java)
                        intent.putExtra("IMAGE_URL", catImage.url)
                        startActivity(intent)
                    }
                    recyclerView.adapter = catAdapter
                } else {
                    Log.e("Favoritos", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<TheCat>>, t: Throwable) {
                Log.e("Favoritos", "Failure: ${t.message}")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú; esto agrega los ítems al action bar si está presente.
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ajustes_action -> {
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Ajustes::class.java)
                startActivity(intent)
                return true
            }
            R.id.registrarse_action -> {
                Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Registro::class.java)
                startActivity(intent)
                return true
            }
            R.id.inicioSesion_action -> {
                Toast.makeText(this, "Inicio de sesión", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.about_action -> {
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
