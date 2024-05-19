package com.example.aguas.adapterText

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.Layout.Datos
import com.example.aguas.R

/**
 * Clase que proporciona la lógica para enlazar los datos con las vistas en un RecyclerView.
 *
 * @property datos Lista de datos a mostrar en el RecyclerView.
 * @constructor Crea una instancia de `Adapter` con la lista de datos proporcionada.
 *
 * @autor Aitor
 * */
class Adapter(private val datos: List<Datos>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    /**
     * Método que se llama cuando se necesita crear una nueva ViewHolder.
     * @param parent El ViewGroup al que se añadirá la nueva vista.
     * @param viewType El tipo de vista de la nueva vista.
     * @return ViewHolder que contiene la nueva vista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(row)
    }

    /**
     * Método que devuelve el número total de elementos en el conjunto de datos.
     * @return Número total de elementos.
     */
    override fun getItemCount() = datos.size
    /**
     * Método que actualiza el contenido de la ViewHolder para reflejar el elemento en la posición dada.
     * @param holder La ViewHolder que debe ser actualizada.
     * @param position La posición del elemento dentro del conjunto de datos.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dato = datos[position]
        holder.bindRow(dato)
    }
    /**
     * Clase interna que representa una ViewHolder para cada elemento en la lista.
     * @param view La vista asociada a la ViewHolder.
     */
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