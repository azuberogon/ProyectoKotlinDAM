package com.example.aguas

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val datos: List<Datos>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(row)
    }
    override fun getItemCount() = datos.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dato = datos[position]
        holder.bindRow(dato)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val circleView: View = view.findViewById(R.id.circleView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val subtitleTextView: TextView = view.findViewById(R.id.subtitleTextView)
        fun bindRow(dato: Datos) {
            titleTextView.text = dato.name
            subtitleTextView.text = dato.hex
            val gradientDrawable = circleView.background as GradientDrawable
            val colorId = android.graphics.Color.parseColor(dato.hex)
            gradientDrawable.setColor(colorId)
        }
    }
}