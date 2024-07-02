package com.app.smartcalculator.view.viewpager

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.smartcalculator.R
import com.app.smartcalculator.app.SmartCalcApp
import com.app.smartcalculator.databinding.ActivityViewPagerBinding
import com.app.smartcalculator.model.DataViewPager
import com.app.smartcalculator.view.main.MainActivity
import com.app.smartcalculator.view.viewpager.adapter.AdapterViewPager

class ViewPagerActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityViewPagerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (SmartCalcApp.getAppInstance().getDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        initView()
        setClick()

    }

    private fun setClick() {
        binding?.btnNext?.setOnClickListener(this)
        binding?.btnSkip?.setOnClickListener(this)
    }

    private fun initView() {
        val adapter = AdapterViewPager(this, addData())
        binding?.viewPager?.adapter = adapter
        binding?.viewPager?.let { binding?.dotsIndicator?.setViewPager(it) }
    }
    private fun addData(): ArrayList<DataViewPager> {
        val data: ArrayList<DataViewPager> = ArrayList()
        data.add(DataViewPager(R.layout.geometry_viewpager))
        data.add(DataViewPager(R.layout.finance_viewpager))
        data.add(DataViewPager(R.layout.health_viewpager))
        return data
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_next -> {
                when (binding?.viewPager?.currentItem) {
                    0 -> {
                        binding?.viewPager?.currentItem = 1
                    }
                    1 -> {
                        binding?.viewPager?.currentItem = 2
                    }
                    else -> {
                        SmartCalcApp.getAppInstance().saveViewPage(true)
                        startActivity(Intent(this, MainActivity::class.java))
                        finishAffinity()
                    }
                }
            }

            R.id.btn_skip -> {
                SmartCalcApp.getAppInstance().saveViewPage(true)
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

}