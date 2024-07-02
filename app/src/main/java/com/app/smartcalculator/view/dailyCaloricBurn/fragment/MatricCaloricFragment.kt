package com.app.smartcalculator.view.dailyCaloricBurn.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentMatricCaloricBinding
import java.text.DecimalFormat

class MatricCaloricFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentMatricCaloricBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatricCaloricBinding.inflate(inflater, container, false)
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
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input age value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input height value."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input weight value."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edt2?.text.toString().toDouble()
                value3 = binding?.edt3?.text.toString().toDouble()
                if (binding?.male!!.isChecked && binding?.sedentary!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format((value3 * 13.75 + value2 * 5.0 - value1 * 6.76 + 66.0) * 1.2))
                } else if (binding?.female!!.isChecked && binding?.sedentary!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format((value3 * 9.56 + value2 * 1.85 - value1 * 4.68 + 579.0) * 1.2))
                } else if (binding?.male!!.isChecked && binding?.lightActive!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format((value3 * 13.75 + value2 * 5.0 - value1 * 6.75 + 75.0) * 1.375))
                } else if (binding?.female!!.isChecked && binding?.lightActive!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format((value3 * 9.56 + value2 * 1.85 - value1 * 4.68 + 578.0) * 1.375))
                } else if (!binding?.male!!.isChecked || !binding?.moderatelyActive?.isChecked!!) {
                    if (binding?.female!!.isChecked) {
                        if (binding?.moderatelyActive!!.isChecked) {
                            binding?.edt4?.setText(decimalFormat.format((value3 * 9.56 + value2 * 1.85 - value1 * 4.68 + 511.0) * 1.55))
                            return
                        }
                    }
                    if (binding?.male!!.isChecked && binding?.veryActive!!.isChecked) {
                        binding?.edt4?.setText(decimalFormat.format((value3 * 13.75 + value2 * 5.0 - value1 * 6.76 + 66.0) * 1.9))
                    } else if (binding?.female!!.isChecked && binding?.veryActive!!.isChecked) {
                        binding?.edt4?.setText(decimalFormat.format((value3 * 9.56 + value2 * 1.85 - value1 * 4.68 + 615.0) * 1.9))
                    }
                } else {
                    binding?.edt4?.setText(decimalFormat.format((value3 * 13.75 + value2 * 5.0 - value1 * 6.60 - 9.00) * 1.55))
                }
            } catch (e: NumberFormatException) {
                val metricCal = this
                metricCal.value1 = 0.0
                metricCal.value2 = 0.0
                metricCal.value3 = 0.0
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