package com.github.takahirom.constraint_layout_samples

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.github.takahirom.constraint_layout_samples.databinding.ActivityBarrierBinding


class BarrierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBarrierBinding = DataBindingUtil.setContentView<ActivityBarrierBinding>(this, R.layout.activity_barrier)
        activityBarrierBinding.emailEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activityBarrierBinding.normalEmailText.text = p0
                activityBarrierBinding.barriorEmailText.text = p0
            }
        })
        activityBarrierBinding.nameEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activityBarrierBinding.normalFullNameText.text = p0
                activityBarrierBinding.barriorFullNameText.text = p0
            }
        })


    }

}
