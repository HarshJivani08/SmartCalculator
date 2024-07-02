package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentTrapezoidBinding
import java.text.DecimalFormat

class TrapezoidFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentTrapezoidBinding? = null
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
        binding = FragmentTrapezoidBinding.inflate(inflater, container, false)

        binding?.trapezoid?.initialLayout?.hint = "Base"
        binding?.trapezoid?.perimeter?.hint = "Median"
        binding?.trapezoid?.edt6?.visibility = View.GONE
        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.trapezoid?.calculateC1?.setOnClickListener(this)
        binding?.trapezoid?.clearC2?.setOnClickListener(this)
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
        if (binding?.trapezoid?.edt1!!.requestFocus() || binding?.trapezoid?.edt5!!.requestFocus() || binding?.trapezoid?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.trapezoid?.edt1?.setText("")
        binding?.trapezoid?.edt2?.setText("")
        binding?.trapezoid?.edt3?.setText("")
        binding?.trapezoid?.edt4?.setText("")
        binding?.trapezoid?.edt5?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.trapezoid?.edt1?.text.toString().isEmpty()) {
            binding?.trapezoid?.edt1?.error = "Input trapezoid base."
            binding?.trapezoid?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.trapezoid?.edt5?.text.toString().isEmpty()) {
            binding?.trapezoid?.edt5?.error = "Input trapezoid top."
            binding?.trapezoid?.edt5?.requestFocus()
            this.keybordopen()
        } else if (binding?.trapezoid?.edt2?.text.toString().isEmpty()) {
            binding?.trapezoid?.edt2?.error = "Input trapezoid height."
            binding?.trapezoid?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.trapezoid?.edt1?.text.toString().toDouble()
                value2 = binding?.trapezoid?.edt5?.text.toString().toDouble()
                value3 = binding?.trapezoid?.edt2?.text.toString().toDouble()
                binding?.trapezoid?.edt3?.setText(decimalFormat.format((value1 + value2) * 0.5 * value3))
                binding?.trapezoid?.edt4?.setText(decimalFormat.format((value1 + value2) * 0.5))
            } catch (e: NumberFormatException) {
                val trapezoid = this@TrapezoidFragment
                trapezoid.value1 = 0.0
                trapezoid.value2 = 0.0
                trapezoid.value3 = 0.0
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