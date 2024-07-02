package com.app.smartcalculator.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.smartcalculator.app.SmartCalcApp
import com.app.smartcalculator.databinding.ActivitySplashBinding
import com.app.smartcalculator.view.main.MainActivity
import com.app.smartcalculator.view.viewpager.ViewPagerActivity


class SplashActivity : AppCompatActivity() {

    private lateinit  var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            if (SmartCalcApp.getAppInstance().getDarkMode()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            initView()
        }
    }

    private fun initView() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (SmartCalcApp.getAppInstance().getViewpage()) {
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } else {
                SmartCalcApp.getAppInstance().saveViewPage(true)
                startActivity(Intent(this, ViewPagerActivity::class.java))
                finishAffinity()
            }

        }, 1000)
    }
}