package io.supercharge.accessibility

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class BasicViewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic_views, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            Snackbar.make(view, R.string.basic_views_login_started, Snackbar.LENGTH_LONG)
//                .setAction(R.string.basic_views_login_cancel) {
//                    Log.d(null, "Cancel login")
//                }
                .show()
        }
    }
}
