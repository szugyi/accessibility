package io.supercharge.accessibility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_basic_views.*
import kotlin.math.min

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

            startLogin()
        }

        button.setOnClickListener {
            Snackbar.make(view, R.string.basic_views_login_started, Snackbar.LENGTH_LONG)
//                .setAction(R.string.basic_views_login_cancel) {
//                    Log.d(null, "Cancel login")
//
//                    login_progress_label.visibility = View.GONE
//                    login_progress.visibility = View.GONE
//                    login_progress_percent.visibility = View.GONE
//                    login_progress.announceForAccessibility("Login cancelled")
//                }
                .show()

            startLogin()
        }
    }

    private fun startLogin() {
        updateProgressPercent(0)

        login_progress_label.visibility = View.VISIBLE
        login_progress.visibility = View.VISIBLE
        login_progress_percent.visibility = View.VISIBLE

        updateProgress()
    }

    private fun updateProgress() {
        login_progress.postDelayed({
            val progress = min(login_progress.progress + 40, 100)
            updateProgressPercent(progress)

            if (progress < 100) {
                updateProgress()
            } else {
                login_progress_label.visibility = View.GONE
                login_progress.visibility = View.GONE
                login_progress_percent.visibility = View.GONE
                login_progress_percent.announceForAccessibility("Login finished")
            }

//            login_progress.contentDescription =
//                "Login in progress: ${login_progress.progress} percent"

        }, 4000)
    }

    private fun updateProgressPercent(progress: Int) {
        if (progress == 0) {
            login_progress_percent.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_NONE
        } else {
            login_progress_percent.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_POLITE
        }

        login_progress.progress = progress

        login_progress_percent.text =
            getString(R.string.basic_views_login_progress_percent, progress)

        login_progress_percent.contentDescription =
            getString(R.string.basic_views_login_progress_percent_description, progress)
    }
}
