package com.app.smartcalculator.view.equationsolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.app.smartcalculator.R
import com.app.smartcalculator.databinding.ActivityEquationSolverBinding
import com.app.smartcalculator.view.TabAdapter
import com.app.smartcalculator.view.equationsolver.fragment.LinearEquationFragment
import com.app.smartcalculator.view.equationsolver.fragment.QuadraticEquationFragment


class EquationSolverActivity : AppCompatActivity(),View.OnClickListener {

    private var binding: ActivityEquationSolverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEquationSolverBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()

        binding?.toolbar?.title?.text = getString(R.string.equation_solver)
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
        setupViewPager(binding?.viewPager!!)
    }

    private fun setClick(){
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun setupViewPager(viewPager2: ViewPager) {
        val viewPagerAdapter = TabAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(LinearEquationFragment(), "Linear Equation")
        viewPagerAdapter.addFragment(QuadraticEquationFragment(), "Quadratic Equation")
        viewPager2.adapter = viewPagerAdapter
    }
}