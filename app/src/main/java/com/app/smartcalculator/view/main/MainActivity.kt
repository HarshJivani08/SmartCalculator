package com.app.smartcalculator.view.main

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.app.smartcalculator.NavDrawerAdapter
import com.app.smartcalculator.R
import com.app.smartcalculator.app.AppConstants
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityMainBinding
import com.app.smartcalculator.model.NavBean
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.main.fragment.algebra.AlgebraFragment
import com.app.smartcalculator.view.main.fragment.finance.FinanceFragment
import com.app.smartcalculator.view.main.fragment.geometry.GeometryFragment
import com.app.smartcalculator.view.main.fragment.health.HealthFragment
import com.app.smartcalculator.view.main.fragment.miscellaneous.MiscellaneousFragment
import com.app.smartcalculator.view.main.fragment.unitConverters.UnitConvertersFragment
import com.app.smartcalculator.view.moreapp.MoreAppActivity
import com.app.smartcalculator.view.policy.PrivacyPolicyActivity
import com.app.smartcalculator.view.search.SearchActivity

class MainActivity : BaseActivity(), View.OnClickListener, NavDrawerAdapter.OnItemClickListeners {

    private var binding: ActivityMainBinding? = null

    private val tabIcons = intArrayOf(
        R.drawable.ic_unit_convertry,
        R.drawable.ic_frame_geometry,
        R.drawable.ic_frame_algebra,
        R.drawable.ic_frame_finance,
        R.drawable.ic_helth,
        R.drawable.ic_miscellaneous
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.main?.tabLayout?.setupWithViewPager(binding?.main?.viewpager)
        setupViewPager(binding?.main?.viewpager!!)
        //setupTabIcons()

        setClick()
        drawerRec()

        binding?.main?.viewpager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
            }

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding?.main?.topicText?.text = "Unit Converters"
                    1 -> binding?.main?.topicText?.text = "Geometry"
                    2 -> binding?.main?.topicText?.text = "Algebra"
                    3 -> binding?.main?.topicText?.text = "Finance"
                    4 -> binding?.main?.topicText?.text = "Health"
                    5 -> binding?.main?.topicText?.text = "Miscellaneous"
                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setClick() {
        binding?.main?.navigateMenu?.setOnClickListener(this)
        binding?.main?.searchImg?.setOnClickListener(this)
    }

    private fun setupTabIcons() {
        binding?.main?.tabLayout?.getTabAt(0)?.setIcon(tabIcons[0])
        binding?.main?.tabLayout?.getTabAt(1)?.setIcon(tabIcons[1])
        binding?.main?.tabLayout?.getTabAt(2)?.setIcon(tabIcons[2])
        binding?.main?.tabLayout?.getTabAt(3)?.setIcon(tabIcons[3])
        binding?.main?.tabLayout?.getTabAt(4)?.setIcon(tabIcons[4])
        binding?.main?.tabLayout?.getTabAt(5)?.setIcon(tabIcons[5])
    }

    private fun setupViewPager(viewPager2: ViewPager) {
        val viewPagerAdapter = TabAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(UnitConvertersFragment(), "Unit Converters")
        viewPagerAdapter.addFragment(GeometryFragment(), "Geometry")
        viewPagerAdapter.addFragment(AlgebraFragment(), "Algebra")
        viewPagerAdapter.addFragment(FinanceFragment(), "Finance")
        viewPagerAdapter.addFragment(HealthFragment(), "Health")
        viewPagerAdapter.addFragment(MiscellaneousFragment(), "Miscellaneous")
        viewPager2.adapter = viewPagerAdapter
    }

    @SuppressLint("RtlHardcoded")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.navigate_menu -> {
                binding?.drawerLayout?.openDrawer(Gravity.LEFT)
            }

            R.id.search_img -> {
                startActivity(Intent(this, SearchActivity::class.java))
            }
        }
    }

    override fun onItemClick(data: NavBean, adapterPosition: Int) {
        when (data.title) {

            getString(R.string.share_our_app) -> {
                shareApp()
            }

            getString(R.string.rate_us) -> {
                rateUs()
            }

            getString(R.string.privacy_policy) -> {
                binding?.drawerLayout?.closeDrawers()
                startActivity(Intent(this, PrivacyPolicyActivity::class.java))
            }

            getString(R.string.more_apps) -> {
                binding?.drawerLayout?.closeDrawers()
                startActivity(Intent(this, MoreAppActivity::class.java))
            }
        }
    }

    private fun drawerRec() {
        binding?.navigationRv.apply {
            binding?.navigationRv?.layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            val adapter = NavDrawerAdapter(this@MainActivity, itemsList(), this@MainActivity)
            binding?.navigationRv?.adapter = adapter
        }
    }

    private fun itemsList(): ArrayList<NavBean> {
        val arrayList = ArrayList<NavBean>()
        arrayList.add(NavBean(R.drawable.ic_carbon_light, getString(R.string.set_dark_mode), true))
        arrayList.add(NavBean(R.drawable.ic_clarity_star_line, getString(R.string.rate_us)))
        arrayList.add(NavBean(R.drawable.ic_carbon_share, getString(R.string.share_our_app)))
        arrayList.add(NavBean(R.drawable.ic_privacy_policy, getString(R.string.privacy_policy)))
//        arrayList.add(NavBean(R.drawable.ic_more, getString(R.string.more_apps)))
        return arrayList
    }

    private fun shareApp() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(
            Intent.EXTRA_TEXT, "Share Application:\n\n" + AppConstants.PLAY_STORE_BASE + packageName
        )
        sendIntent.type = "text/plain"
        startActivity(Intent.createChooser(sendIntent, "Share Using"))
    }

    private fun rateUs() {
        val uri = Uri.parse(AppConstants.PLAY_STORE_BASE + this.packageName)
        val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            this.startActivity(myAppLinkToMarket)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, " Sorry, Not able to open!", Toast.LENGTH_SHORT).show()
        }
    }


}