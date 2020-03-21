package pl.tkadziolka.motionlayout

import androidx.constraintlayout.motion.widget.MotionLayout

class MotionProgressListener(private val progressListener: (Float) -> Unit) :
    MotionLayout.TransitionListener {
    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}
    override fun onTransitionChange(layout: MotionLayout?, p1: Int, p2: Int, progress: Float) {
        progressListener.invoke(progress)
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}
}