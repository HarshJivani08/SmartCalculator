package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentSquarePyramidBinding
import java.text.DecimalFormat
import kotlin.math.sqrt

class SquarePyramidFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentSquarePyramidBinding? = null
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
        binding = FragmentSquarePyramidBinding.inflate(inflater, container, false)

        binding?.pyramid?.edt5?.visibility = View.GONE
        binding?.pyramid?.edt4?.visibility = View.GONE

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.pyramid?.calculateC1?.setOnClickListener(this)
        binding?.pyramid?.clearC2?.setOnClickListener(this)
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
        if (binding?.pyramid?.edt1!!.requestFocus() || binding?.pyramid?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.pyramid?.edt1?.setText("")
        binding?.pyramid?.edt2?.setText("")
        binding?.pyramid?.edt3?.setText("")
        binding?.pyramid?.edt6?.setText("")

    }

    private fun caluculateValue() {

        if (binding?.pyramid?.edt1?.text.toString().isEmpty()) {
            binding?.pyramid?.edt1?.error = "Input square pyramid side."
            binding?.pyramid?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.pyramid?.edt2?.text.toString().isEmpty()) {
            binding?.pyramid?.edt2?.error = "Input square pyramid height."
            binding?.pyramid?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.pyramid?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.pyramid?.edt2?.text.toString().toDouble()
                val sqrt: Double =
                    value1 * value1 + value1 * sqrt(
                        value1 * value1 + value2 * value2 * 4.0
                    )
                binding?.pyramid?.edt6?.setText(decimalFormat.format(value2 * value1 * value1 / 3.0))
                binding?.pyramid?.edt3?.setText(decimalFormat.format(sqrt))
            } catch (e: NumberFormatException) {
                val squarePyramid = this
                squarePyramid.value1 = 0.0
                squarePyramid.value2 = 0.0
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