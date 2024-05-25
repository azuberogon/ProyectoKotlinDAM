import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.R
import com.example.aguas.data.TheCat
import com.squareup.picasso.Picasso

/**
 * Clase que proporciona la lógica para enlazar los datos de imágenes de gatos con las vistas en un RecyclerView.
 *
 * @property catImages Lista de imágenes de gatos a mostrar en el RecyclerView.
 * @property clickListener Función de devolución de llamada para manejar clics en elementos de la lista.
 * @constructor Crea una instancia de `CatAdapter` con la lista de imágenes de gatos y la función de devolución de llamada proporcionadas.
 */
class CatAdapter(
    private val catImages: List<TheCat>,
    private val clickListener: (TheCat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    /**
     * Método que se llama cuando se necesita crear una nueva ViewHolder.
     * @param parent El ViewGroup al que se añadirá la nueva vista.
     * @param viewType El tipo de vista de la nueva vista.
     * @return ViewHolder que contiene la nueva vista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(view)
    }

    /**
     * Método que actualiza el contenido de la ViewHolder para reflejar el elemento en la posición dada.
     * @param holder La ViewHolder que debe ser actualizada.
     * @param position La posición del elemento dentro del conjunto de datos.
     */
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val catImage = catImages[position]
        Picasso.get().load(catImage.url).into(holder.catImageView)
        holder.itemView.setOnClickListener { clickListener(catImage) }
    }

    /**
     * Método que devuelve el número total de elementos en el conjunto de datos.
     * @return Número total de elementos.
     */
    override fun getItemCount(): Int = catImages.size

    /**
     * Clase interna que representa una ViewHolder para cada elemento en la lista.
     * @param itemView La vista asociada a la ViewHolder.
     */
    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImageView: ImageView = itemView.findViewById(R.id.cat_image)
    }
}



