package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.takahirom.constraint_layout_samples.databinding.ActivityGroupBinding


class GroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupBinding = DataBindingUtil.setContentView<ActivityGroupBinding>(this, R.layout.activity_group)
        groupBinding.toggleButton.setOnCheckedChangeListener { _, b ->
            groupBinding.group.visibility = if (b) View.VISIBLE else View.GONE
        }
    }

}
