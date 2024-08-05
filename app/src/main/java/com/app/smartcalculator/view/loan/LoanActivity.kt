package com.app.smartcalculator.view.loan
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityLoanBinding
import java.text.DecimalFormat
import kotlin.math.pow

class LoanActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityLoanBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoanBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        spinnerList()
        binding?.toolbar?.title?.text = getString(R.string.loan)
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
            R.id.calculate_c1 -> {
                calculateValue()
            }
        }
    }

    private fun calculateValue() {

        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input loan value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input rate percentage"
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input time period."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            val obj: String = binding?.spinner?.selectedItem.toString()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edt2?.text.toString().toDouble()
                value3 = binding?.edt3?.text.toString().toDouble()
                if (obj == "Years") {
                    value2 /= 1200.0
                    value3 *= 12.0
                    val pow: Double =
                        value1 * value2 * (value2 + 1.0).pow(value3) / ((value2 + 1.0).pow(value3) - 1.0)
                    val d: Double = value3 * pow
                    binding?.edt4?.setText(decimalFormat.format(pow))
                    binding?.edt5?.setText(decimalFormat.format(d))
                    binding?.edt6?.setText(decimalFormat.format(d - value1))
                } else if (obj == "Months") {
                    value2 /= 1200.0
                    val pow2: Double = (value2 + value2 / ((value2 + 1.0).pow(value3) - 1.0)) * value1
                    val d2: Double = value3 * pow2
                    binding?.edt4?.setText(decimalFormat.format(pow2))
                    binding?.edt5?.setText(decimalFormat.format(d2))
                    binding?.edt6?.setText(decimalFormat.format(d2 - value1))
                }
            } catch (e: NumberFormatException) {
                val mainFinanceLoan = this
                mainFinanceLoan.value1 = 0.0
                mainFinanceLoan.value2 = 0.0
                mainFinanceLoan.value3 = 0.0
            }
        }
    }

    private fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt2?.setText("")
        binding?.edt1?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
        binding?.edt5?.setText("")
        binding?.edt6?.setText("")
    }

    @SuppressLint("WrongConstant")
    fun keybordopen() {
        (getSystemService("input_method") as InputMethodManager).showSoftInput(currentFocus, 1)
    }

    @SuppressLint("WrongConstant")
    fun keybordclose() {
        (getSystemService("input_method") as InputMethodManager).hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            0
        )
    }

    private fun spinnerList() {
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, getSelection())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding?.spinner?.adapter = arrayAdapter
        binding?.spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun getSelection(): ArrayList<String> {
        val mainList = ArrayList<String>()
        mainList.add("Years")
        mainList.add("Months")
        return mainList
    }




}