package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentCircleArcBinding

import java.text.DecimalFormat

class Circle_arcFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentCircleArcBinding? = null
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
        binding = FragmentCircleArcBinding.inflate(inflater, container, false)

        binding?.circleArc?.initialLayout?.hint = "Radius"
        binding?.circleArc?.thirdLayout?.hint = "Angle"
        binding?.circleArc?.edt5?.visibility = View.GONE
        binding?.circleArc?.edt4?.visibility = View.GONE
        binding?.circleArc?.edt6?.visibility = View.GONE

        setClick()
  
        return binding!!.root
    }

    private fun setClick() {
        binding?.circleArc?.calculateC1?.setOnClickListener(this)
        binding?.circleArc?.clearC2?.setOnClickListener(this)
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
        if (binding?.circleArc?.edt1!!.requestFocus() || binding?.circleArc?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.circleArc?.edt1?.setText("")
        binding?.circleArc?.edt2?.setText("")
        binding?.circleArc?.edt3?.setText("")

    }

    private fun caluculateValue() {

        if (binding?.circleArc?.edt1?.text.toString().isEmpty()) {
            binding?.circleArc?.edt1?.error = "Input circle arc radius."
            binding?.circleArc?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.circleArc?.edt2?.text.toString().isEmpty()) {
            binding?.circleArc?.edt2?.error = "Input circle arc angle."
            binding?.circleArc?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.circleArc?.edt1?.text.toString().toDouble()
                value2 = binding?.circleArc?.edt2?.text.toString().toDouble()
                binding?.circleArc?.edt3?.setText(decimalFormat.format(value1 * 22.0 * value1 / 7.0 * (value2 / 360.0)))
            } catch (e: NumberFormatException) {

                val circle_Arc = this
                circle_Arc.value1 = 0.0
                circle_Arc.value2 = 0.0
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