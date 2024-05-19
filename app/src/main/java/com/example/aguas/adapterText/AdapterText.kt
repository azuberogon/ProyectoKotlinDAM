package com.example.aguas.adapterText

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.R
/**
 *
 *
 *
 *
 * @autor Aitor
 * Clase que proporciona la lógica para enlazar los datos de texto con las vistas en un RecyclerView.
 *
 * @property dataSet Array de cadenas de texto a mostrar en el RecyclerView.
 * @constructor Crea una instancia de `AdapterText` con el conjunto de datos proporcionado.
*/
class AdapterText(private val dataSet: Array<String>) :
RecyclerView.Adapter<AdapterText.ViewHolder>() {

/**
 * Clase interna que representa una ViewHolder para cada elemento en la lista.
 * @param view La vista asociada a la ViewHolder.
*/
class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
val textView: TextView = view.findViewById(R.id.loremimpsun)
}

/**
 * Método que se llama cuando se necesita crear una nueva ViewHolder.
 * @param parent El ViewGroup al que se añadirá la nueva vista.
 * @param viewType El tipo de vista de la nueva vista.
 * @return ViewHolder que contiene la nueva vista.
*/
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view = LayoutInflater.from(parent.context)
.inflate(R.layout.activity_about, parent, false)
return ViewHolder(view)
}

/**
 * Método que actualiza el contenido de la ViewHolder para reflejar el elemento en la posición dada.
 * @param holder La ViewHolder que debe ser actualizada.
 * @param position La posición del elemento dentro del conjunto de datos.
*/
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.textView.text = dataSet[position]
}

/**
 * Método que devuelve el número total de elementos en el conjunto de datos.
 * @return Número total de elementos.
*/
override fun getItemCount() = dataSet.size
}

