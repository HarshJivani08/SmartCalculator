package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import com.app.smartcalculator.R

import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentRectangleBinding
import java.text.DecimalFormat

class RectangleFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentRectangleBinding? = null

    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRectangleBinding.inflate(inflater, container, false)

        setClick()
        binding?.rectangle?.initialLayout?.hint = "Length"
        binding?.rectangle?.thirdLayout?.hint = "width"
        binding?.rectangle?.edt5?.visibility = View.GONE
        binding?.rectangle?.edt6?.visibility = View.GONE
        return binding!!.root
    }

    private fun setClick() {
        binding?.rectangle?.calculateC1?.setOnClickListener(this)
        binding?.rectangle?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.calculate_c1 -> {
                caluculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }
    }

    private fun clearValue() {
        if (binding?.rectangle?.edt1!!.requestFocus() || binding?.rectangle?.edt2!!.requestFocus()) {
            keybordclose()
        }
        binding?.rectangle?.edt1?.setText("")
        binding?.rectangle?.edt2?.setText("")
        binding?.rectangle?.edt3?.setText("")
        binding?.rectangle?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.rectangle?.edt1?.text.toString().isEmpty()) {
            binding?.rectangle?.edt1?.error = "Input rectangle length."
            binding?.rectangle?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.rectangle?.edt2?.text.toString().isEmpty()) {
            binding?.rectangle?.edt2?.error = "Input rectangle width."
            binding?.rectangle?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.rectangle?.edt1?.text.toString().toDouble()
                value2 = binding?.rectangle?.edt2?.text.toString().toDouble()
                binding?.rectangle?.edt3?.setText(decimalFormat.format(value1 * value2))
                binding?.rectangle?.edt4?.setText(decimalFormat.format(value1 * 2.0 + value2 * 2.0))
            } catch (e: NumberFormatException) {
                val rectangleFragment = this@RectangleFragment
                rectangleFragment.value1 = 0.0
                rectangleFragment.value2 = 0.0
            }
        }
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