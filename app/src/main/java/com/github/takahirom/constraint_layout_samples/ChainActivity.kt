package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.takahirom.constraint_layout_samples.databinding.ActivityChainBinding

import kotlinx.android.synthetic.main.activity_chain.*

class ChainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityChainBinding = DataBindingUtil.setContentView<ActivityChainBinding>(this, R.layout.activity_chain)
        activityChainBinding.switchButton.setOnCheckedChangeListener { _, b ->
            activityChainBinding.button4.visibility = if(b) View.VISIBLE else View.GONE
            activityChainBinding.button7.visibility = if(b) View.VISIBLE else View.GONE
            activityChainBinding.button10.visibility = if(b) View.VISIBLE else View.GONE
        }
    }

}
