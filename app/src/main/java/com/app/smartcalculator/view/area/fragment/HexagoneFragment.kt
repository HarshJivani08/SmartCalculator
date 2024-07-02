package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentHexagoneBinding
import java.text.DecimalFormat
import kotlin.math.sqrt

class HexagoneFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentHexagoneBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHexagoneBinding.inflate(inflater, container, false)

        setClick()
        binding?.hexagon?.edt2?.visibility = View.GONE
        binding?.hexagon?.edt5?.visibility = View.GONE
        binding?.hexagon?.edt6?.visibility = View.GONE
        return binding!!.root
    }

    private fun setClick() {
        binding?.hexagon?.calculateC1?.setOnClickListener(this)
        binding?.hexagon?.clearC2?.setOnClickListener(this)
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
        if (binding?.hexagon?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.hexagon?.edt1?.setText("")
        binding?.hexagon?.edt3?.setText("")
        binding?.hexagon?.edt4?.setText("")

    }

    private fun caluculateValue() {
        if (binding?.hexagon?.edt1?.text.toString().isEmpty()) {
            binding?.hexagon?.edt1?.error = "Input hexagon side."
            binding?.hexagon?.edt1?.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 = binding?.hexagon?.edt1?.text.toString().toDouble()
            binding?.hexagon?.edt3?.setText(decimalFormat.format(sqrt(3.0) * 3.0 * (value1 * value1) / 2.0))
            binding?.hexagon?.edt4?.setText(decimalFormat.format(value1 * 6.0))
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