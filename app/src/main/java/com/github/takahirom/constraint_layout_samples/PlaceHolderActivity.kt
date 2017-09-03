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
        val onClickListener: (View) -> Unit = { view ->
            TransitionManager.beginDelayedTransition(placeHolderBinding.root as ViewGroup)
            placeHolderBinding.placeholder.setContentId(view.id)
        }
        placeHolderBinding.imageA.setOnClickListener(onClickListener)
        placeHolderBinding.imageB.setOnClickListener(onClickListener)
        placeHolderBinding.imageC.setOnClickListener(onClickListener)
        placeHolderBinding.imageD.setOnClickListener(onClickListener)

    }

}
