package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentConeBinding
import java.text.DecimalFormat
import kotlin.math.sqrt

class ConeFragment : BaseFragment(),View.OnClickListener {

    private var binding: FragmentConeBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConeBinding.inflate(inflater, container, false)

        binding?.cone?.edt5?.visibility = View.GONE
        binding?.cone?.initialLayout?.hint = "Radius"
        setClick()
        return binding!!.root
    }


    private fun setClick() {
        binding?.cone?.calculateC1?.setOnClickListener(this)
        binding?.cone?.clearC2?.setOnClickListener(this)
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

    private fun caluculateValue() {

        if (binding?.cone?.edt1?.text.toString().isEmpty()) {
            binding?.cone?.edt1?.error = "Input cone radius."
            binding?.cone?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.cone?.edt2?.text.toString().isEmpty()) {
            binding?.cone?.edt2?.error = "Input cone height."
            binding?.cone?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.cone?.edt1?.text.toString().toDouble()
                value2 = binding?.cone?.edt2?.text.toString().toDouble()
                val sqrt: Double =
                    value1 * 3.141592653589793 * (value1 + sqrt(
                        value2 * value2 + value1 * value1
                    ))
                binding?.cone?.edt6?.setText(decimalFormat.format(value1 * 1.0471975511965976 * value1 * value2))
                binding?.cone?.edt3?.setText(decimalFormat.format(sqrt))
                binding?.cone?.edt4?.setText(decimalFormat.format(value1 * 6.283185307179586))
            } catch (e: NumberFormatException) {
                val cone = this
                cone.value1 = 0.0
                cone.value2 = 0.0
            }
        }
    }

    private fun clearValue() {
        if (binding?.cone?.edt1!!.requestFocus() || binding?.cone?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.cone?.edt1?.setText("")
        binding?.cone?.edt2?.setText("")
        binding?.cone?.edt3?.setText("")
        binding?.cone?.edt4?.setText("")
        binding?.cone?.edt6?.setText("")

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