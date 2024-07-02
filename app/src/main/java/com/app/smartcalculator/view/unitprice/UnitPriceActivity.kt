package com.app.smartcalculator.view.unitprice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityUnitPriceBinding
import java.text.DecimalFormat

class UnitPriceActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivityUnitPriceBinding? = null
    var ans1 = 0.0
    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnitPriceBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.unit_price)
        setClick()
    }


    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressed()
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
            binding?.edt1?.error = "Input price value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input quantity value."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                ans1 = value1 / value2
                binding?.edt3?.setText(decimalFormat.format(ans1))
            } catch (e: NumberFormatException) {
                val mainFinanceUnit = this
                mainFinanceUnit.value1 = 0.0
                mainFinanceUnit.value2 = 0.0
            }
        }
    }

    private fun clearValue() {

        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt2?.setText("")
        binding?.edt1?.setText("")
        binding?.edt3?.setText("")
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


}