package com.app.smartcalculator.view.bodyFatPercentage
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityBodyFatBinding
import java.text.DecimalFormat

class BodyFatPercentageActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityBodyFatBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBodyFatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.body_fat)
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

            R.id.calculate_c1 -> {
                calculateValue()
            }

            R.id.clear_c2 -> {
                clearValue()
            }
        }
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
            binding?.edt3?.error = "Input waist value."
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
                if (binding?.male!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format(64.0 - value2 / value3 * 20.0 + 0.0))
                } else if (binding?.female!!.isChecked) {
                    binding?.edt4?.setText(decimalFormat.format(64.0 - value2 / value3 * 20.0 + 12.0))
                }
            } catch (e: NumberFormatException) {
                val mainFatPercentage = this
                mainFatPercentage.value1 = 0.0
                mainFatPercentage.value2 = 0.0
                mainFatPercentage.value3 = 0.0
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
