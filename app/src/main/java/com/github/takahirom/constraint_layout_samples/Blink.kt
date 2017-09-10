package com.github.takahirom.constraint_layout_samples

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.support.constraint.ConstraintHelper
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

class Blink : ConstraintHelper {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun updatePreLayout(container: ConstraintLayout) {
        super.updatePreLayout(container)

        for (i in 0 until this.mCount) {
            val id = this.mIds[i]
            val view = container.getViewById(id)
            if (view != null) {
                ObjectAnimator.ofFloat(view, "alpha", 1F, 0F).apply {
                    repeatCount = ValueAnimator.INFINITE
                    repeatMode = ValueAnimator.REVERSE
                }.start()
            }
        }
    }
}
