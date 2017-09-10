package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import com.github.takahirom.constraint_layout_samples.databinding.ActivityBiasBinding

class BiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBiasBinding = DataBindingUtil.setContentView<ActivityBiasBinding>(this, R.layout.activity_bias)
        activityBiasBinding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                val constraintSet = ConstraintSet()
                constraintSet.clone(activityBiasBinding.constraintLayout)
                val bias = progress.toFloat() * 0.01F
                constraintSet.setVerticalBias(R.id.button, bias)
                constraintSet.setHorizontalBias(R.id.button, bias)
                constraintSet.applyTo(activityBiasBinding.constraintLayout)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    }
}
