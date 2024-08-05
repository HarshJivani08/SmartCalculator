package com.app.smartcalculator.view.dailyCaloricBurn

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityDailyCaloricBurnBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.dailyCaloricBurn.fragment.ImperialCaloricFragment
import com.app.smartcalculator.view.dailyCaloricBurn.fragment.MatricCaloricFragment

class DailyCaloricBurnActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityDailyCaloricBurnBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyCaloricBurnBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.daily_burn)

        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        setClick()
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }

        }
    }

    private fun setupViewPager(viewPager2: ViewPager) {
        val viewPagerAdapter = TabAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(MatricCaloricFragment(), "Metric")
        viewPagerAdapter.addFragment(ImperialCaloricFragment(), "Imperial")
        viewPager2.adapter = viewPagerAdapter
    }
}