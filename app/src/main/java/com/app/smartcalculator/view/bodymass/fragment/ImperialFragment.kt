package com.app.smartcalculator.view.bodymass.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentImperialBinding
import java.text.DecimalFormat

class ImperialFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentImperialBinding? = null

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
        binding = FragmentImperialBinding.inflate(inflater, container, false)

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.calculate_c1 -> {
                calculateValue()
            }

            R.id.clear_c2 -> {
                clearValue()
            }

        }

    }

    private fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt3?.setText("")
        binding?.edtIn?.setText("")

    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input body height ft."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edtIn?.text.toString().isEmpty()) {
            binding?.edtIn?.error = "Input body height in."
            binding?.edtIn?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input body weight."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edtIn?.text.toString().toDouble()
                value3 = binding?.edt2?.text.toString().toDouble()
                val d: Double = value1 * 12.0 + value2
                binding?.edt3?.setText(decimalFormat.format(value3 * 703.0 / (d * d)))
            } catch (e: NumberFormatException) {
                val imperial = this
                imperial.value1 = 0.0
                imperial.value2 = 0.0
                imperial.value3 = 0.0
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