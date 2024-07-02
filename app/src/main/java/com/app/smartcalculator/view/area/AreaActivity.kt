package com.app.smartcalculator.view.area
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityAreaBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.area.fragment.CircleFragment
import com.app.smartcalculator.view.area.fragment.Circle_arcFragment
import com.app.smartcalculator.view.area.fragment.EllipseFragment
import com.app.smartcalculator.view.area.fragment.HexagoneFragment
import com.app.smartcalculator.view.area.fragment.ParallelogramFragment
import com.app.smartcalculator.view.area.fragment.PentagonFragment
import com.app.smartcalculator.view.area.fragment.RectangleFragment
import com.app.smartcalculator.view.area.fragment.RhombusFragment
import com.app.smartcalculator.view.area.fragment.SquareFragment
import com.app.smartcalculator.view.area.fragment.TrapezoidFragment
import com.app.smartcalculator.view.area.fragment.TriangleFragment



class AreaActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityAreaBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAreaBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        setClick()

        binding?.toolbar?.title?.text = getString(R.string.area)
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
        viewPagerAdapter.addFragment(TriangleFragment(), "Triangle")
        viewPagerAdapter.addFragment(SquareFragment(), "Square")
        viewPagerAdapter.addFragment(RectangleFragment(), "Rectangle")
        viewPagerAdapter.addFragment(ParallelogramFragment(), "Parallelogram")
        viewPagerAdapter.addFragment(TrapezoidFragment(), "Trapezoid")
        viewPagerAdapter.addFragment(RhombusFragment(), "Rhombus")
        viewPagerAdapter.addFragment(HexagoneFragment(), "Hexagon")
        viewPagerAdapter.addFragment(PentagonFragment(), "Pentagon")
        viewPagerAdapter.addFragment(CircleFragment(), "Circle")
        viewPagerAdapter.addFragment(Circle_arcFragment(), "Circle_arc")
        viewPagerAdapter.addFragment(EllipseFragment(), "Ellipse")
        viewPager2.adapter = viewPagerAdapter
    }

}