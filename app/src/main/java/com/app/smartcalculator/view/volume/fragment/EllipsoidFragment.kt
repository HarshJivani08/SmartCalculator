package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentEllipsoidBinding
import java.text.DecimalFormat

class EllipsoidFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentEllipsoidBinding? = null
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
    ): View {
        binding = FragmentEllipsoidBinding.inflate(inflater, container, false)
        binding?.ellipsoid?.perimeter?.visibility = View.GONE
        binding?.ellipsoid?.edt3?.visibility = View.GONE
        binding?.ellipsoid?.initialLayout?.hint = "Radius X"
        binding?.ellipsoid?.discountLayout?.hint = "Radius Y"
        binding?.ellipsoid?.thirdLayout?.hint = "Radius Z"

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.ellipsoid?.calculateC1?.setOnClickListener(this)
        binding?.ellipsoid?.clearC2?.setOnClickListener(this)
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
        if (binding?.ellipsoid?.edt1!!.requestFocus() || binding?.ellipsoid?.edt5!!.requestFocus() || binding?.ellipsoid?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.ellipsoid?.edt6?.setText("")
        binding?.ellipsoid?.edt1?.setText("")
        binding?.ellipsoid?.edt2?.setText("")
        binding?.ellipsoid?.edt5?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.ellipsoid?.edt1?.text.toString().isEmpty()) {
            binding?.ellipsoid?.edt1?.error = "Input radius x."
            binding?.ellipsoid?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.ellipsoid?.edt5?.text.toString().isEmpty()) {
            binding?.ellipsoid?.edt5?.error = "Input radius y."
            binding?.ellipsoid?.edt5?.requestFocus()
            this.keybordopen()
        } else if (binding?.ellipsoid?.edt2?.text.toString().isEmpty()) {
            binding?.ellipsoid?.edt2?.error = "Input radius z."
            binding?.ellipsoid?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.ellipsoid?.edt1?.text.toString().toDouble()
                value2 = binding?.ellipsoid?.edt5?.text.toString().toDouble()
                value3 = binding?.ellipsoid?.edt2?.text.toString().toDouble()
//                binding?.ellipsoid?.edt6?.setText(decimalFormat.format(value1 * 4.178318229274425 * value2 * value3))
                binding?.ellipsoid?.edt6?.setText(decimalFormat.format((value1 * 12.56636 * value2 * value3)/3))
            } catch (e: NumberFormatException) {
                val ellipsoid = this
                ellipsoid.value1 = 0.0
                ellipsoid.value2 = 0.0
                ellipsoid.value3 = 0.0
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