package io.supercharge.accessibility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.supercharge.accessibility.R
import kotlinx.android.synthetic.main.page_item_product.view.*

class ProductRecyclerViewAdapter(private val items: MutableList<Product>) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_product,
            parent,
            false
        )

        view.setOnClickListener {
            items.removeAt(3)
            notifyItemRemoved(3)
        }

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.name!!
        private val price = view.price!!

        fun bindItem(item: Product) {
            name.text = item.name
            price.text = itemView.context.getString(R.string.product_item_price_text, item.price)
        }
    }
}