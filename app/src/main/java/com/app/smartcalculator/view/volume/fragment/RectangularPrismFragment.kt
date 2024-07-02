package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentRectangularPrismBinding
import java.text.DecimalFormat

class RectangularPrismFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentRectangularPrismBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRectangularPrismBinding.inflate(inflater, container, false)

        binding?.prism?.initialLayout?.hint = "Length"
        binding?.prism?.thirdLayout?.hint = "Height"
        binding?.prism?.discountLayout?.hint = "Width"
        setClick()
        return binding!!.root
    }


    private fun setClick() {
        binding?.prism?.calculateC1?.setOnClickListener(this)
        binding?.prism?.clearC2?.setOnClickListener(this)
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

        if (binding?.prism?.edt1!!.requestFocus() || binding?.prism?.edt5!!.requestFocus() || binding?.prism?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.prism?.edt1?.setText("")
        binding?.prism?.edt2?.setText("")
        binding?.prism?.edt3?.setText("")
        binding?.prism?.edt4?.setText("")
        binding?.prism?.edt5?.setText("")
        binding?.prism?.edt6?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.prism?.edt1?.getText().toString().isEmpty()) {
            binding?.prism?.edt1?.setError("Input length value.")
            binding?.prism?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.prism?.edt5?.getText().toString().isEmpty()) {
            binding?.prism?.edt5?.setError("Input width value.")
            binding?.prism?.edt5?.requestFocus()
            this.keybordopen()

        } else if (binding?.prism?.edt2?.getText().toString().isEmpty()) {
            binding?.prism?.edt2?.setError("Input height value.")
            binding?.prism?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.prism?.edt1?.getText().toString().toDouble()
                value2 =
                    binding?.prism?.edt5?.getText().toString().toDouble()
                value3 =
                    binding?.prism?.edt2?.getText().toString().toDouble()
                val d: Double =
                    value1 * 2.0 * value3 + value2 * 2.0 * value1 + value2 * 2.0 * value3
                binding?.prism?.edt4?.setText(decimalFormat.format((value1 + value2 + value3) * 4.0))
                binding?.prism?.edt6?.setText(decimalFormat.format(value1 * value2 * value3))
                binding?.prism?.edt3?.setText(decimalFormat.format(d))
            } catch (e: NumberFormatException) {
                val rectangular_Prism = this
                rectangular_Prism.value1 = 0.0
                rectangular_Prism.value2 = 0.0
                rectangular_Prism.value3 = 0.0
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