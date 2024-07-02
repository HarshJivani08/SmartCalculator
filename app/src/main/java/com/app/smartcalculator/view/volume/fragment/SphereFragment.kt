package com.app.smartcalculator.view.volume.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentSphereBinding

import java.text.DecimalFormat
import kotlin.math.pow

class SphereFragment : BaseFragment(),View.OnClickListener {
    private var binding: FragmentSphereBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSphereBinding.inflate(inflater, container, false)

        binding?.sphere?.edt5?.visibility = View.GONE
        binding?.sphere?.edt2?.visibility = View.GONE
        binding?.sphere?.perimeter?.visibility = View.GONE
        binding?.sphere?.initialLayout?.hint = "Radius"

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.sphere?.calculateC1?.setOnClickListener(this)
        binding?.sphere?.clearC2?.setOnClickListener(this)
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
        if (binding?.sphere?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.sphere?.edt1?.setText("")
        binding?.sphere?.edt3?.setText("")
        binding?.sphere?.edt4?.setText("")

    }

    private fun caluculateValue() {
        if (binding?.sphere?.edt1?.text.toString().isEmpty()) {
            binding?.sphere?.edt1?.error = "Input sphere radius."
            binding?.sphere?.edt1?.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 = binding?.sphere?.edt1?.text.toString().toDouble()
            binding?.sphere?.edt6?.setText(decimalFormat.format(value1.pow(3.0) * 12.566370614359172 / 3.0)
            )
            binding?.sphere?.edt3?.setText(
                decimalFormat.format(
                    value1.pow(2.0) * 12.566370614359172
                )
            )
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