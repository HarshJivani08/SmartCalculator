package com.app.smartcalculator.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class TabAdapter(fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager!!) {
    private val mFragmentList: MutableList<Fragment?> = ArrayList()
    private val mFragmentTitleList: ArrayList<String?> = ArrayList()
    override fun getItem(i: Int): Fragment {
        return mFragmentList[i]!!
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, str: String?) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(str)
    }

    override fun getPageTitle(i: Int): CharSequence {
        return mFragmentTitleList[i].toString()
    }
}

