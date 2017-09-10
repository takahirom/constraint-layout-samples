package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.github.takahirom.constraint_layout_samples.databinding.ActivityPlaceHolderBinding


class PlaceHolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val placeHolderBinding = DataBindingUtil.setContentView<ActivityPlaceHolderBinding>(this, R.layout.activity_place_holder)
        placeHolderBinding.apply {
            val onClickListener: (View) -> Unit = { view ->
                TransitionManager.beginDelayedTransition(root as ViewGroup)
                placeholder.setContentId(view.id)
            }
            imageA.setOnClickListener(onClickListener)
            imageB.setOnClickListener(onClickListener)
            imageC.setOnClickListener(onClickListener)
            imageD.setOnClickListener(onClickListener)
        }

    }

}
