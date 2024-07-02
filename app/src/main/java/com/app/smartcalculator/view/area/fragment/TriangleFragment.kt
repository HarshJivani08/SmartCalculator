package com.app.smartcalculator.view.area.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R

import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentTriangleBinding

import java.text.DecimalFormat


class TriangleFragment : BaseFragment(),View.OnClickListener {

    private var binding: FragmentTriangleBinding? = null

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
        binding = FragmentTriangleBinding.inflate(inflater, container, false)

        setClick()

        binding?.triangle?.perimeter?.visibility = View.GONE
        binding?.triangle?.edt5?.visibility = View.GONE
        binding?.triangle?.edt6?.visibility = View.GONE
        return binding!!.root
    }

    private fun setClick() {
        binding?.triangle?.calculateC1?.setOnClickListener(this)
        binding?.triangle?.clearC2?.setOnClickListener(this)
    }

    fun caluculateValue(){
        if (binding?.triangle?.edt1?.text.toString().isEmpty()) {
            binding?.triangle?.edt1?.error = "Input triangle side."
            binding?.triangle?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.triangle?.edt2?.text.toString().isEmpty()) {
            binding?.triangle?.edt2?.error = "Input triangle height."
            binding?.triangle?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.triangle?.edt1?.text.toString().toDouble()
                value2 = binding?.triangle?.edt2?.text.toString().toDouble()
                binding?.triangle?.edt3?.setText(decimalFormat.format(value1 * value2 / 2.0))
            } catch (e: NumberFormatException) {
                val triangle: TriangleFragment = this
                triangle.value1 = 0.0
                triangle.value2 = 0.0
            }
        }
    }

    fun clearValue(){
        if ( binding?.triangle?.edt1!!.requestFocus() ||  binding?.triangle?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.triangle?.edt1?.setText("")
        binding?.triangle?.edt2?.setText("")
        binding?.triangle?.edt3?.setText("")
    }


    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.calculate_c1 -> {
                caluculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
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