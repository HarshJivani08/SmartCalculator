package com.app.smartcalculator.view.volume
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityVolumeBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.volume.fragment.ConeFragment
import com.app.smartcalculator.view.volume.fragment.CubeFragment
import com.app.smartcalculator.view.volume.fragment.CylinderFragment
import com.app.smartcalculator.view.volume.fragment.EllipsoidFragment
import com.app.smartcalculator.view.volume.fragment.RectangularPrismFragment
import com.app.smartcalculator.view.volume.fragment.SphereFragment
import com.app.smartcalculator.view.volume.fragment.SquarePyramidFragment


class VolumeActivity : AppCompatActivity(),View.OnClickListener {

    private var binding: ActivityVolumeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolumeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
        setClick()

        binding?.toolbar?.title?.text = getString(R.string.volume)
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
        viewPagerAdapter.addFragment(CubeFragment(), "Cube")
        viewPagerAdapter.addFragment(RectangularPrismFragment(), "Rectangular Prism")
        viewPagerAdapter.addFragment(SquarePyramidFragment(), "Square Pyramid")
        viewPagerAdapter.addFragment(CylinderFragment(), "Cylinder")
        viewPagerAdapter.addFragment(ConeFragment(), "Cone")
        viewPagerAdapter.addFragment(SphereFragment(), "Sphere")
        viewPagerAdapter.addFragment(EllipsoidFragment(), "Ellipsoid")
        viewPager2.adapter = viewPagerAdapter
    }

}