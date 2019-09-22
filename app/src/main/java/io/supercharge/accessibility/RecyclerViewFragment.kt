package io.supercharge.accessibility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.supercharge.accessibility.adapter.Product
import io.supercharge.accessibility.adapter.ProductRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import java.math.BigDecimal

class RecyclerViewFragment : Fragment() {
    private val productNames = listOf("Hammer", "Pliers", "Saw", "Screwdriver", "Sandpaper")

    private val products = mutableListOf(
        Product(name = "Hammer", price = BigDecimal.valueOf(42)),
        Product(name = "Pliers", price = BigDecimal.valueOf(67)),
        Product(name = "Saw", price = BigDecimal.valueOf(105)),
        Product(name = "Screwdriver", price = BigDecimal.valueOf(18)),
        Product(name = "Sandpaper", price = BigDecimal.valueOf(3))
    )

    private val productAdapter = ProductRecyclerViewAdapter(products)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = productAdapter

        add_button.setOnClickListener {
            products.add(0, generateProduct())
            productAdapter.notifyItemInserted(0)
        }

        remove_button.setOnClickListener {
            if (products.size <= 3) {
                return@setOnClickListener
            }

            products.removeAt(3)
            productAdapter.notifyItemRemoved(3)
        }

        change_button.setOnClickListener {
            if (products.size <= 3) {
                return@setOnClickListener
            }

            products[3] = generateProduct()
            productAdapter.notifyItemChanged(3)
        }
    }

    private fun generateProduct(): Product {
        return Product(name = "Test", price = BigDecimal.ONE)
    }
}
