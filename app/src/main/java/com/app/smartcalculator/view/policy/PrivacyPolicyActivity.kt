package com.app.smartcalculator.view.policy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityPrivacyPolicyBinding

class PrivacyPolicyActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPrivacyPolicyBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClick()

    }
    private fun setClick() {
        binding.toolbar.backImg.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressed()
            }
        }
    }
}