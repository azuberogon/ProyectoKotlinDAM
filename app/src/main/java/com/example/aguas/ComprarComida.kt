package com.example.aguas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.example.aguas.data.dataBase.CatDatabase
import com.example.aguas.data.dataBase.entity.Cat
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class ComprarComida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_comida)

        val imageView: ImageView = findViewById(R.id.detail_cat_image)
        val saveButton: Button = findViewById(R.id.save_button)

        val imageUrl = intent.getStringExtra("IMAGE_URL")
        val catId = intent.getStringExtra("CAT_ID")

        if (imageUrl != null) {
            Picasso.get().load(imageUrl).into(imageView)
        }

        saveButton.setOnClickListener {
            if (catId != null && imageUrl != null) {
                val cat = Cat(catId, imageUrl)
                saveCatToDatabase(cat)
            }
        }

    }
    private fun saveCatToDatabase(cat: Cat) {
        val catDao = CatDatabase.getDatabase(application).catDao()
        lifecycleScope.launch {
            catDao.insert(cat)
        }
    }
}