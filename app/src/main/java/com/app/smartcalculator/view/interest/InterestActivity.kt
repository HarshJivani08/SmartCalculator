package com.app.smartcalculator.view.interest

import SimpleInterestFragment
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityInterestBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.interest.fragment.CompoundInterestFragment

class InterestActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityInterestBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        binding?.toolbar?.title?.text = getString(R.string.interest)
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
        viewPagerAdapter.addFragment(SimpleInterestFragment(), "Simple Interest")
        viewPagerAdapter.addFragment(CompoundInterestFragment(), "Compound Interest")
        viewPager2.adapter = viewPagerAdapter
    }

}