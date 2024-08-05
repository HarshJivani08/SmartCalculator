package com.app.smartcalculator.view.bodymass
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityBodyMassBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.bodymass.fragment.ImperialFragment
import com.app.smartcalculator.view.bodymass.fragment.MetricFragment

class BodyMassActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityBodyMassBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBodyMassBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        setClick()

        binding?.toolbar?.title?.text = getString(R.string.body_mass)
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
        viewPagerAdapter.addFragment(MetricFragment(), "Metric")
        viewPagerAdapter.addFragment(ImperialFragment(), "Imperial")
        viewPager2.adapter = viewPagerAdapter
    }
}