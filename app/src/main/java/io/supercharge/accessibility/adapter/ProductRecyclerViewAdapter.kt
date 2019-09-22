package io.supercharge.accessibility.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import io.supercharge.accessibility.R
import kotlinx.android.synthetic.main.list_item_product.view.*
import kotlinx.android.synthetic.main.page_item_product.view.name
import kotlinx.android.synthetic.main.page_item_product.view.price

class ProductRecyclerViewAdapter(private val items: MutableList<Product>) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_product,
            parent,
            false
        )

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItem(items[position], position)

        holder.itemView.setOnClickListener {
            if (holder.adapterPosition == RecyclerView.NO_POSITION) {
                return@setOnClickListener
            }

            items.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            holder.itemView.isAccessibilityHeading = position % 10 == 0
        }
    }

    override fun getItemCount(): Int = items.size

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.image
        private val name = view.name
        private val price = view.price

        fun bindItem(item: Product, position: Int) {
            name.text = item.name
            price.text = itemView.context.getString(R.string.product_item_price_text, item.price)

            Glide.with(itemView.context)
                .load("https://picsum.photos/300/300?$position")
                .apply(RequestOptions.circleCropTransform())
                .into(image)
        }
    }
}