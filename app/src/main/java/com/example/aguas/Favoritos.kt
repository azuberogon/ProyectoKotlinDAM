package com.example.aguas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.Layout.*
import com.example.aguas.adapterText.CatAdapterFav
import com.example.aguas.data.ApiGatos
import com.example.aguas.data.TheCat
import com.example.aguas.data.dataBase.LocalDataBase
import com.example.aguas.data.dataBase.entity.Cat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Favoritos : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapterFav: CatAdapterFav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCatImages()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.misgatos -> {
                    val intent = Intent(this@Favoritos, Menu::class.java)
                    startActivity(intent)
                    true
                }
                R.id.compra -> {
                    val intent = Intent(this@Favoritos, ComprarComida::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun fetchCatImages() {
        val db = LocalDataBase.getInstance(this)
        val catDao = db.catDao()

        // Fetch cats from local database
        CoroutineScope(Dispatchers.IO).launch {
            val cats = catDao.getAllCats()
            runOnUiThread {
                catAdapterFav = CatAdapterFav(cats)
                recyclerView.adapter = catAdapterFav
            }
        }

        // Fetch cats from API
        val apiService = ApiGatos.RetrofitClient.instance.create(ApiGatos.CatApiService::class.java)
        apiService.getRandomCats(20).enqueue(object : Callback<List<TheCat>> {
            override fun onResponse(call: Call<List<TheCat>>, response: Response<List<TheCat>>) {
                if (response.isSuccessful) {
                    val catImages = response.body()!!
                    catAdapterFav = CatAdapterFav(catImages.map { Cat(0, it.url, "Nombre Desconocido", 0, "Desconocido", false) })
                    recyclerView.adapter = catAdapterFav
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
