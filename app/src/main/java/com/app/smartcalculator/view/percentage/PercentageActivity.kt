package com.app.smartcalculator.view.percentage
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityPercentageBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.percentage.fragment.DiscountFragment
import com.app.smartcalculator.view.percentage.fragment.IncreaseFragment
import com.app.smartcalculator.view.percentage.fragment.IncreseDecreseFragment
import com.app.smartcalculator.view.percentage.fragment.SimplePercentageFragment

class PercentageActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityPercentageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPercentageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.percentage)
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressed()
            }
        }
    }

    private fun setupViewPager(viewPager2: ViewPager) {
        val viewPagerAdapter = TabAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(DiscountFragment(), "Discount")
        viewPagerAdapter.addFragment(IncreaseFragment(), "Increase")
        viewPagerAdapter.addFragment(SimplePercentageFragment(), "Simple Percentage")
        viewPagerAdapter.addFragment(IncreseDecreseFragment(), "Perc.Increase/Decrease")
        viewPager2.adapter = viewPagerAdapter
    }
}