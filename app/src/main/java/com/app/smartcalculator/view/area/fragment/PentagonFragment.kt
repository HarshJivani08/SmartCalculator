package com.app.smartcalculator.view.area.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentPentagonBinding
import java.text.DecimalFormat
import kotlin.math.sqrt

class PentagonFragment : BaseFragment(),View.OnClickListener {
    private var binding: FragmentPentagonBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPentagonBinding.inflate(inflater, container, false)

        setClick()
        binding?.pentagon?.edt2?.visibility = View.GONE
        binding?.pentagon?.edt5?.visibility = View.GONE
        binding?.pentagon?.edt6?.visibility = View.GONE
        return binding!!.root
    }

    private fun setClick() {
        binding?.pentagon?.calculateC1?.setOnClickListener(this)
        binding?.pentagon?.clearC2?.setOnClickListener(this)
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
        if (binding?.pentagon?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.pentagon?.edt1?.setText("")
        binding?.pentagon?.edt3?.setText("")
        binding?.pentagon?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if ( binding?.pentagon?.edt1?.text.toString().isEmpty()) {
            binding?.pentagon?.edt1?.error = "Input pentagon side."
            binding?.pentagon?.edt1?.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 =  binding?.pentagon?.edt1?.text.toString().toDouble()
            binding?.pentagon?.edt3?.setText(decimalFormat.format(sqrt((sqrt(5.0) * 2.0 + 5.0) * 5.0) * value1 * value1 / 4.0))
            binding?.pentagon?.edt4?.setText(decimalFormat.format(value1 * 5.0))
        } catch (e: NumberFormatException) {
            value1 = 0.0
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