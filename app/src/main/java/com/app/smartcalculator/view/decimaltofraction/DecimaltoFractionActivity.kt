package com.app.smartcalculator.view.decimaltofraction
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityDecimaltoFractionBinding
import kotlin.math.floor

class DecimaltoFractionActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityDecimaltoFractionBinding? = null
    var value1 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecimaltoFractionBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.decimal_to_fraction)
    }

    fun caluculateValue(){
        if (binding?.editTextDf1?.text.toString().isEmpty()) {
            binding?.editTextDf1?.error = "Input decimal value."
            binding?.editTextDf1?.requestFocus()
            this.keybordopen()

        }
        this.keybordclose()
        try {
            value1 = binding?.editTextDf1?.text.toString().toDouble()
            binding?.editTextDf2?.setText(
                this.convertDecimalToFraction(
                    value1
                )
            )
        } catch (e: NumberFormatException) {
            value1 = 0.0
        }
    }


    fun clearValue(){
        if (binding?.editTextDf1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextDf2?.setText("")
        binding?.editTextDf1?.setText("")
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

    private fun convertDecimalToFraction(d: Double): String {
        var d2 = d
        if (d2 < 0.0) {
            return "-" + convertDecimalToFraction(-d2)
        }
        var d9 = 0.0
        var d4 = 0.0
        var d5 = 1.0
        var d6 = 1.0
        var d7 = d2
        while (true) {
            val floor = floor(d7)
            val d8 = floor * d5 + d9
            val d3 = d9
            val d92 = floor * d4 + d6
            d7 = 1.0 / (d7 - floor)
            if (Math.abs(d2 - d8 / d92) <= 1.0E-6 * d2) {
                val d10 = d2
                return "$d8/$d92"
            }
            val d22 = d2
            val d102 = d4
            d4 = d92
            d6 = d102
            val d11 = d5
            d5 = d8
            d9 = d11
            d2 = d22
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.back_img -> {
                onBackPressed()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
            R.id.calculate_c1 -> {
                caluculateValue()
            }
        }
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }



}