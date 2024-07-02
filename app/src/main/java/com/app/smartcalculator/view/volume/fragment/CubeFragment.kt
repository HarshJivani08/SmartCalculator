package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentCubeBinding
import java.text.DecimalFormat

class CubeFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentCubeBinding? = null
    var value1 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCubeBinding.inflate(inflater, container, false)

        binding?.cube?.edt5?.visibility = View.GONE
        binding?.cube?.edt2?.visibility = View.GONE
        setClick()
        return binding!!.root
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

        if (binding?.cube?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.cube?.edt1?.setText("")
        binding?.cube?.edt6?.setText("")
        binding?.cube?.edt3?.setText("")
        binding?.cube?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.cube?.edt1?.text.toString().isEmpty()) {
            binding?.cube?.edt1?.error = "Input cube side."
            binding?.cube?.edt1?.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 = binding?.cube?.edt1?.text.toString().toDouble()
            val d: Double = value1 * value1 * value1
            binding?.cube?.edt6?.setText(decimalFormat.format(d))
            binding?.cube?.edt3?.setText(decimalFormat.format(value1 * value1 * 6.0))
            binding?.cube?.edt4?.setText(decimalFormat.format(value1 * 12.0))
        } catch (e: NumberFormatException) {
            value1 = 0.0
        }

    }

    private fun setClick() {
        binding?.cube?.calculateC1?.setOnClickListener(this)
        binding?.cube?.clearC2?.setOnClickListener(this)
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