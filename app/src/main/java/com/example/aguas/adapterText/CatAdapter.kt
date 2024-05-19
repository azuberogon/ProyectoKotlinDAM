import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.aguas.R
import com.example.aguas.data.TheCat
import com.squareup.picasso.Picasso

class CatAdapter(
    private val catImages: List<TheCat>,
    private val clickListener: (TheCat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val catImage = catImages[position]
        Picasso.get().load(catImage.url).into(holder.catImageView)
        holder.itemView.setOnClickListener { clickListener(catImage) }
    }

    override fun getItemCount(): Int = catImages.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImageView: ImageView = itemView.findViewById(R.id.cat_image)
    }
}
