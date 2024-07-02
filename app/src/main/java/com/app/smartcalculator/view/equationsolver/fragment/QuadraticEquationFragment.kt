package com.app.smartcalculator.view.equationsolver.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentQuadraticEquationBinding
import java.text.DecimalFormat

class QuadraticEquationFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentQuadraticEquationBinding? = null
    val decimalFormat = DecimalFormat("###.##")

    var ans1 = 0.0
    var ans2 = 0.0
    var ans3 = 0.0
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuadraticEquationBinding.inflate(inflater, container, false)

        setClick()
        return binding!!.root

    }


    fun calculateValue() {
        if (binding?.edtA?.getText().toString().isEmpty()) {
            binding?.edtA?.setError("Input a value.")
            binding?.edtA?.requestFocus()
            this.keybordopen()
        } else if (binding?.edtB?.getText().toString().isEmpty()) {
            binding?.edtB?.setError("Input b value.")
            binding?.edtB?.requestFocus()
            this.keybordopen()
        } else if (binding?.edtC?.getText().toString().isEmpty()) {
            binding?.edtC?.setError("Input c value.")
            binding?.edtC?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edtA?.getText().toString().toDouble()
                value2 = binding?.edtB?.getText().toString().toDouble()
                value3 = binding?.edtC?.getText().toString().toDouble()
                ans1 = value2 * value2 - value1 * 4.0 * value3
                ans2 =
                    (-value2 + Math.sqrt(ans1)) / (value1 * 2.0)
                ans3 = (-value2 - Math.sqrt(ans1)) / (value1 * 2.0)
                binding?.resultX1?.setText(decimalFormat.format(ans2))
                binding?.resultX2?.setText(decimalFormat.format(ans3))
            } catch (e: NumberFormatException) {

                val quadratic_Equation: QuadraticEquationFragment = this
                quadratic_Equation.value1 = 0.0
                quadratic_Equation.value3 = 0.0
                quadratic_Equation.value2 = 0.0
            }
        }
    }

    fun clearValue() {
        if (binding?.edtA!!.requestFocus() || binding?.edtB!!.requestFocus() || binding?.edtC!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edtB!!.setText("")
        binding?.edtC!!.setText("")
        binding?.edtA!!.setText("")
        binding?.resultX1!!.text = ""
        binding?.resultX2!!.text = ""
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.calculate_c1 -> {
                calculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }
    }

    fun setClick() {
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    @SuppressLint("WrongConstant")
    fun keybordopen() {
        (requireActivity().getSystemService("input_method") as InputMethodManager).showSoftInput(
            requireActivity().currentFocus, 1
        )
    }

    @SuppressLint("WrongConstant")
    fun keybordclose() {
        (requireActivity().getSystemService("input_method") as InputMethodManager).hideSoftInputFromWindow(
            requireActivity().currentFocus!!.windowToken, 0
        )
    }


}