package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentCylinderBinding
import java.text.DecimalFormat

class CylinderFragment : BaseFragment() ,View.OnClickListener{
    private var binding: FragmentCylinderBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCylinderBinding.inflate(inflater, container, false)

        binding?.cylinder?.edt5?.visibility = View.GONE
        binding?.cylinder?.initialLayout?.hint = "Radius"
        setClick()
        return binding!!.root
    }


    private fun setClick() {
        binding?.cylinder?.calculateC1?.setOnClickListener(this)
        binding?.cylinder?.clearC2?.setOnClickListener(this)
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
        if (binding?.cylinder?.edt1!!.requestFocus() || binding?.cylinder?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.cylinder?.edt1?.setText("")
        binding?.cylinder?.edt2?.setText("")
        binding?.cylinder?.edt3?.setText("")
        binding?.cylinder?.edt4?.setText("")
        binding?.cylinder?.edt6?.setText("")

    }

    private fun caluculateValue() {

        if (binding?.cylinder?.edt1?.text.toString().isEmpty()) {
            binding?.cylinder?.edt1?.error = "Input cylinder radius."
            binding?.cylinder?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.cylinder?.edt2?.text.toString().isEmpty()) {
            binding?.cylinder?.edt2?.error = "Input cylinder height."
            binding?.cylinder?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.cylinder?.edt1?.getText().toString().toDouble()
                value2 = binding?.cylinder?.edt2?.getText().toString().toDouble()
                val d: Double = value1 * 6.283185307179586 * (value1 + value2)
                binding?.cylinder?.edt6?.setText(decimalFormat.format(value1 * 3.141592653589793 *value1 * value2))
                binding?.cylinder?.edt3?.setText(decimalFormat.format(d))
//                binding?.cylinder?.edt4?.setText(decimalFormat.format(value1 * 12.566))
                binding?.cylinder?.edt4?.setText(decimalFormat.format((4 * value1) + (2 * value2)))
            } catch (e: NumberFormatException) {
                val cylinder = this
                cylinder.value1 = 0.0
                cylinder.value2 = 0.0
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