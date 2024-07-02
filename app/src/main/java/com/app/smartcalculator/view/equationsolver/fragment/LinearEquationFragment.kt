package com.app.smartcalculator.view.equationsolver.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentLinearEquationBinding
import java.text.DecimalFormat


class LinearEquationFragment : BaseFragment(), View.OnClickListener {

    var disc = 0.0
    var discans = 0.0
    var harga1 = 0.0

    private var binding: FragmentLinearEquationBinding? = null
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLinearEquationBinding.inflate(inflater, container, false)
        setClick()
        return binding!!.root
    }


    private fun calculateValue() {
        if (binding?.edtA?.text.toString().isEmpty()) {
            binding?.edtA?.error = "Input a value."
            binding?.edtA?.requestFocus()
            this.keybordopen()
        } else if (binding?.edtB?.text.toString().isEmpty()) {
            binding?.edtB?.error = "Input b value."
            binding?.edtB?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                harga1 =
                    binding?.edtA?.text.toString().toDouble()
                disc =
                    binding?.edtB?.text.toString().toDouble()
                discans = -(disc / harga1)
                binding?.ansText?.text = decimalFormat.format(discans)
            } catch (e: NumberFormatException) {
                val linear_Equation: LinearEquationFragment = this
                linear_Equation.harga1 = 0.0
                linear_Equation.disc = 0.0
            }
        }
    }

    private fun clearValue() {
        if (binding?.edtA!!.requestFocus() || binding?.edtB!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edtB?.setText("")
        binding?.ansText?.text = ""
        binding?.edtA?.setText("")
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

    private fun setClick() {
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
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


}