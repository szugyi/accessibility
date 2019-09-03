package io.supercharge.accessibility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import io.supercharge.accessibility.R
import kotlinx.android.synthetic.main.page_item_product.view.*

class ProductPagerAdapter(private val items: List<Product>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val itemView = inflater.inflate(R.layout.page_item_product, container, false)

        val item = items[position]
        itemView.name.text = item.name
        itemView.price.text = container.context.getString(R.string.product_item_price_text, item.price)

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as View)
    }

    override fun getPageTitle(position: Int): CharSequence? = items[position].name

    override fun isViewFromObject(view: View, o: Any): Boolean = view === o

    override fun getCount(): Int = items.size
}