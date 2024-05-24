package com.example.aguas.adapterText

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.R
import com.example.aguas.data.dataBase.entity.Cat
import com.squareup.picasso.Picasso

class CatAdapterFav(private val catList: List<Cat>) : RecyclerView.Adapter<CatAdapterFav.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = catList[position]
        Picasso.get().load(cat.url).into(holder.catImageView)
        holder.catNameTextView.text = cat.nombre ?: "Nombre Desconocido"
        holder.catAgeTextView.text = cat.edad?.toString() ?: "Edad Desconocida"
        holder.catGenderTextView.text = cat.genero ?: "Género Desconocido"
    }

    override fun getItemCount(): Int = catList.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImageView: ImageView = itemView.findViewById(R.id.catImageView)
        val catNameTextView: TextView = itemView.findViewById(R.id.catNameTextView)
        val catAgeTextView: TextView = itemView.findViewById(R.id.catAgeTextView)
        val catGenderTextView: TextView = itemView.findViewById(R.id.catGenderTextView)
    }
}
