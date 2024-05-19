package com.example.aguas

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 *
 *
 *
 * @autor Aitor
 * */
class menu : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCatImages()


       /* val recycler: RecyclerView =
            findViewById(R.id.recycler)
        recycler.adapter = Adapter(
            listOf(
                Datos( "Azul", "#2196F3"),
                Datos( "Rojo", "#2196F3"),
                Datos( "Naranja", "#2196F3"),
                Datos( "Azul", "#2196F3"),
                Datos( "Rojo", "#2196F3"),
                Datos( "Naranja", "#2196F3")
            )
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



*/




    }

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
                    Log.e("MainActivity", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<TheCat>>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú; esto agrega los ítems al action bar si está presente.
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }
    override fun onOptionsItemSelected (item: MenuItem): Boolean {
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
                Toast.makeText(this, "inicio de sesion", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.about_action -> {
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, About::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
    private fun buildColors (): List<Datos> {
        return listOf(
            Datos(getString(R.string.red), getColorHex(R.color.red)),
            Datos(getString(R.string.indigo), getColorHex(R.color.indigo)),
            Datos(getString(R.string.green), getColorHex(R.color.green)),
            Datos(getString(R.string.orange), getColorHex(R.color.orange)),
            Datos(getString(R.string.blue), getColorHex(R.color.blue)),
            Datos(getString(R.string.yellow), getColorHex(R.color.yellow)),
            Datos(getString(R.string.bluegrey), getColorHex(R.color.bluegrey)),
            Datos(getString(R.string.teal), getColorHex(R.color.teal)),
            Datos(getString(R.string.deeppurple), getColorHex(R.color.deeppurple)),
            Datos(getString(R.string.cyan), getColorHex(R.color.cyan)),
            Datos(getString(R.string.brown), getColorHex(R.color.brown))
        )
    }
    private fun getColorHex (colorResId: Int): String {
        return String.format("#%06X", 0xFFFFFF and ContextCompat.getColor( this, colorResId))
    }





}



