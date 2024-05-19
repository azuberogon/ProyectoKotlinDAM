package com.example.aguas.Layout

import CatAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.aguas.data.ApiGatos
import com.example.aguas.data.TheCat
import android.util.Log
import com.example.aguas.Favoritos
import com.example.aguas.R
import com.example.aguas.cestaDeLaCompra
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Actividad del menú principal que muestra una lista de imágenes de gatos obtenidas desde una API.
 *
 * Esta actividad también proporciona opciones de menú para navegar a otras partes de la aplicación, como ajustes, registro, inicio de sesión y sobre.
 *
 * @constructor Crea una instancia de `menu`.
 * @property recyclerView El RecyclerView que muestra las imágenes de gatos.
 * @property catAdapter El adaptador para el RecyclerView que maneja la lista de imágenes de gatos.
 * @see AppCompatActivity
 * @since 1.0
 * @author Aitor
 */
class menu : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    /**
     * Método de callback que se llama cuando la actividad es creada.
     *
     * Configura el RecyclerView y llama a la función para obtener las imágenes de gatos desde la API.
     *
     * @param savedInstanceState Instancia de estado de la actividad previamente guardada, si la hay.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCatImages()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCatImages()

        // Configuración del BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.add_favorites -> {
                    val intent = Intent(this@menu, Favoritos::class.java)
                    startActivity(intent)
                    true
                }
                R.id.misgatos -> {
                    // No estoy seguro de qué actividad debería abrir esta opción
                    // Aquí puedes cambiarla según lo que necesites
                    val intent = Intent(this@menu, Menu::class.java)
                    startActivity(intent)
                    true
                }
                R.id.compra -> {
                    val intent = Intent(this@menu, cestaDeLaCompra::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }



    /**
     * Obtiene las imágenes de gatos desde la API y las muestra en el RecyclerView.
     */
    private fun fetchCatImages() {
        val apiService = ApiGatos.RetrofitClient.instance.create(ApiGatos.CatApiService::class.java)
        apiService.getRandomCats(20).enqueue(object : Callback<List<TheCat>> {
            override fun onResponse(call: Call<List<TheCat>>, response: Response<List<TheCat>>) {
                if (response.isSuccessful) {
                    val catImages = response.body()!!
                    catAdapter = CatAdapter(catImages) { catImage ->
                        val intent = Intent(this@menu, ComprarComida::class.java)
                        intent.putExtra("IMAGE_URL", catImage.url)
                        startActivity(intent)
                    }
                    recyclerView.adapter = catAdapter
                } else {
                    Log.e("Menu", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<TheCat>>, t: Throwable) {
                Log.e("Menu", "Failure: ${t.message}")
            }
        })
    }

    /**
     * Infla el menú; esto agrega los ítems al action bar si está presente.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }

    /**
     * Maneja los clics en los ítems del menú.
     */
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
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}



