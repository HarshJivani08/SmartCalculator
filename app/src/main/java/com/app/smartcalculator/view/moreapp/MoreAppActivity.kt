package com.app.smartcalculator.view.moreapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityMoreAppBinding

class MoreAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}