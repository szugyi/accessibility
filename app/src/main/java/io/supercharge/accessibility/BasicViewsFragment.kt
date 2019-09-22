package io.supercharge.accessibility

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_basic_views.*

class BasicViewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic_views, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_view_button.setOnClickListener {
            Snackbar.make(view, R.string.basic_views_login_started, Snackbar.LENGTH_LONG)
                .show()
        }

        button.setOnClickListener {
            Snackbar.make(view, R.string.basic_views_login_started, Snackbar.LENGTH_LONG)
                .setAction(R.string.basic_views_login_cancel) {
                    Log.d(null, "Cancel login")
                }
                .show()
        }
    }
}
