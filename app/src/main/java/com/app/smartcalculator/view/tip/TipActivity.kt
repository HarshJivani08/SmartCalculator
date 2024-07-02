package com.app.smartcalculator.view.tip

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityTipBinding
import java.text.DecimalFormat

class TipActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityTipBinding? = null
    var ans1 = 0.0
    var ans2 = 0.0
    var ans3 = 0.0
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.tip)
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
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
            binding?.edt1?.error = "Input bill price."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input no.of.people"
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input tip percentage."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                value3 =
                    binding?.edt3?.text.toString().toDouble()
                ans1 =
                    value1 / 100.0 * value3
                ans2 = value1 + ans1
                ans3 = ans2 / value2
                binding?.edt4?.setText(decimalFormat.format(ans1))
                binding?.edt5?.setText(decimalFormat.format(ans2))
                binding?.edt6?.setText(decimalFormat.format(ans3))
            } catch (e: NumberFormatException) {
                val mainFinanceTip = this
                mainFinanceTip.value1 = 0.0
                mainFinanceTip.value2 = 0.0
                mainFinanceTip.value3 = 0.0
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



}