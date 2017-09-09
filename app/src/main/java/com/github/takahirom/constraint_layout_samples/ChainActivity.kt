package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.takahirom.constraint_layout_samples.databinding.ActivityChainBinding

class ChainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityChainBinding = DataBindingUtil.setContentView<ActivityChainBinding>(this, R.layout.activity_chain)
        activityChainBinding.apply {
            switchButton.setOnCheckedChangeListener { _, b ->
                val visibility = if (b) View.GONE else View.VISIBLE
                button4.visibility = visibility
                button7.visibility = visibility
                button10.visibility = visibility
            }
        }
    }

}
