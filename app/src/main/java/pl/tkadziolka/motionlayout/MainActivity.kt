package pl.tkadziolka.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Most of the transitions you can achieve using standard Animator class
//        ObjectAnimator.ofFloat(card, "radius", 0f, 200f).apply {
//            duration = 5000
//            start()
//        }

        bottomSheetSwitch.setOnCheckedChangeListener { _, bottomSheetSmall ->
            if (bottomSheetSmall)
                motionLayout.loadLayoutDescription(R.xml.expandable_bottom_sheet_small)
            else
                motionLayout.loadLayoutDescription(R.xml.expandable_bottom_sheet_big)
        }

        list.adapter = RvAdapter { name ->
            editText.setText(name)
            motionLayout.transitionToEnd()
        }

        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    motionLayout.transitionToStart()
                    editText.setText("")
                }
            }
        })

        motionLayout.setTransitionListener(MotionProgressListener { progress: Float ->
            lottie.progress = progress

            arrow.isVisible = (progress <= 0.5f)
            editText.isVisible = (progress >= 0.5f)
        })
    }
}
