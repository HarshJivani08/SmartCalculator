package com.app.smartcalculator.view.averageMean
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityAverageMeanBinding
import java.text.DecimalFormat

class AverageMeanActivity : BaseActivity(), View.OnClickListener {

    var arithmatic = 0.0
    val decimalFormat = DecimalFormat("###.##")
    var geo = 0.0
    var har = 0.0
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    private var binding: ActivityAverageMeanBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAverageMeanBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.average_mean)

    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
    }

    fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input value x1."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input value x2."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input value x3."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edt2?.text.toString().toDouble()
                value3 = binding?.edt3?.text.toString().toDouble()
                arithmatic = (value1 + value2 + value3) / 3.0
                geo = Math.cbrt(value1 * value2 * value3)
                har = 3.0 / (1.0 / value1 + 1.0 / value2 + 1.0 / value3)
                binding?.edt4?.setText(decimalFormat.format(arithmatic))
                binding?.edt5?.setText(decimalFormat.format(geo))
                binding?.edt6?.setText(decimalFormat.format(har))
            } catch (e: NumberFormatException) {

                val averageMean: AverageMeanActivity = this
                averageMean.value1 = 0.0
                averageMean.value2 = 0.0
                averageMean.value3 = 0.0
            }
        }
    }

    fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt4!!.setText("")
        binding?.edt2!!.setText("")
        binding?.edt1!!.setText("")
        binding?.edt3!!.setText("")
        binding?.edt5!!.setText("")
        binding?.edt6!!.setText("")
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


}