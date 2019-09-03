package io.supercharge.accessibility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.supercharge.accessibility.adapter.Product
import io.supercharge.accessibility.adapter.ProductPageAdapter2
import io.supercharge.accessibility.adapter.ProductPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.*
import java.math.BigDecimal

class ViewPagerFragment : Fragment() {
    private val products = listOf(
        Product(name = "Hammer", price = BigDecimal.valueOf(42)),
        Product(name = "Pliers", price = BigDecimal.valueOf(67)),
        Product(name = "Saw", price = BigDecimal.valueOf(105)),
        Product(name = "Screwdriver", price = BigDecimal.valueOf(18)),
        Product(name = "Sandpaper", price = BigDecimal.valueOf(3))
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter = ProductPagerAdapter(products)
        viewPager2.adapter = ProductPageAdapter2(products)
    }
}
