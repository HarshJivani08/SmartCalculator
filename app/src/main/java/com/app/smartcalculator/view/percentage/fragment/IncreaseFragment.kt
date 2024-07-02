package com.app.smartcalculator.view.percentage.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentIncreaseBinding
import java.text.DecimalFormat

class IncreaseFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentIncreaseBinding? = null

    var discans = 0.0
    var finalans = 0.0
    var harga1 = 0.0
    var inc = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIncreaseBinding.inflate(inflater, container, false)

        setClick()

        return binding!!.root
    }

    private fun setClick() {
        binding?.clearC2?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
    }

    fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input initial value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input increase percentage."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                harga1 = binding?.edt1?.text.toString().toDouble()
                inc = binding?.edt2?.text.toString().toDouble()
                discans = inc / 100.0 * harga1
                finalans = harga1 + discans
                binding?.edt3?.setText(decimalFormat.format(finalans))
                binding?.edt4?.setText(decimalFormat.format(discans))
            } catch (e: NumberFormatException) {
                val increase: IncreaseFragment = this
                increase.harga1 = 0.0
                increase.inc = 0.0
            }
        }
    }

    fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
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