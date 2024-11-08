package dev.rulim34.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_product)
        val textView: TextView = itemView.findViewById(R.id.text_product_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        // Menggunakan Glide untuk memuat gambar
        Glide.with(holder.itemView.context)
            .load(product.imageResId)
            .placeholder(R.drawable.progress_activity_24dp) // Gambar placeholder
            .into(holder.imageView)
        holder.textView.text = product.name
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}