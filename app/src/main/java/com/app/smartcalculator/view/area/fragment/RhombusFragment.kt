package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentRhombusBinding


import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

class RhombusFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentRhombusBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0
    var value2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRhombusBinding.inflate(inflater, container, false)

        binding?.rhombus?.initialLayout?.hint = "Length"
        binding?.rhombus?.thirdLayout?.hint = "width"
        binding?.rhombus?.edt5?.visibility = View.GONE
        binding?.rhombus?.edt6?.visibility = View.GONE
        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.rhombus?.calculateC1?.setOnClickListener(this)
        binding?.rhombus?.clearC2?.setOnClickListener(this)
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

        if (binding?.rhombus?.edt1!!.requestFocus() || binding?.rhombus?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.rhombus?.edt1?.setText("")
        binding?.rhombus?.edt2?.setText("")
        binding?.rhombus?.edt3?.setText("")
        binding?.rhombus?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.rhombus?.edt1?.text.toString().isEmpty()) {
            binding?.rhombus?.edt1?.error = "Input rhombus length."
            binding?.rhombus?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.rhombus?.edt2?.text.toString().isEmpty()) {
            binding?.rhombus?.edt2?.error = "Input rhombus width."
            binding?.rhombus?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.rhombus?.edt1?.text.toString().toDouble()
                value2 = binding?.rhombus?.edt2?.text.toString().toDouble()
                binding?.rhombus?.edt3?.setText(decimalFormat.format(value1 * value2 / 2.0))
                binding?.rhombus?.edt4?.setText(
                    decimalFormat.format(
                        sqrt(
                            value1.pow(2.0) + value2.pow(2.0)
                        ) * 2.0
                    )
                )
            } catch (e: NumberFormatException) {
                val rhombus = this@RhombusFragment
                rhombus.value1 = 0.0
                rhombus.value2 = 0.0
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