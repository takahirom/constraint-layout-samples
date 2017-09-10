package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import com.github.takahirom.constraint_layout_samples.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    var isBigImage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val binding = DataBindingUtil.setContentView<ActivityAnimationBinding>(this, R.layout.activity_animation)

        binding.apply {
            val context = this@AnimationActivity

            val originalConstraintSet = ConstraintSet()
            originalConstraintSet.clone(constraintLayout)

            val bigImageConstraintSet = ConstraintSet()
            bigImageConstraintSet.clone(context, R.layout.big_image)

            constraintLayout.setOnClickListener {
                isBigImage = !isBigImage

                val constraintSet = if (isBigImage) bigImageConstraintSet else originalConstraintSet

                TransitionManager.beginDelayedTransition(constraintLayout)
                constraintSet.applyTo(constraintLayout)
            }


        }

    }
}
