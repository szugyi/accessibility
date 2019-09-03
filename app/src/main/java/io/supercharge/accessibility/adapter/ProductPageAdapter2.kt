package io.supercharge.accessibility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.supercharge.accessibility.R
import kotlinx.android.synthetic.main.page_item_product.view.*

class ProductPageAdapter2(private val items: List<Product>) :
    RecyclerView.Adapter<ProductPageAdapter2.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.page_item_product,
                parent,
                false
            )
        )
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