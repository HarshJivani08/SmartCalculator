package com.app.smartcalculator.view.ohm
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityOhmLawBinding
import java.text.DecimalFormat

class OhmLawActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivityOhmLawBinding? = null

    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOhmLawBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.ohm)
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
                onBackPressedDispatcher.onBackPressed()
            }
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
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
        binding?.edt5?.setText("")
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt6?.setText("")
    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input current value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input resistance value."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                val d: Double =
                    value1 * value2
                val d2: Double = d / value2
                binding?.edt3?.setText(decimalFormat.format(d))
                binding?.edt4?.setText(decimalFormat.format(d2))
                binding?.edt5?.setText(decimalFormat.format(d / d2))
                binding?.edt6?.setText(decimalFormat.format(d2 * d))
            } catch (e: NumberFormatException) {
                val mainMiscellaneousOhm = this
                mainMiscellaneousOhm.value1 = 0.0
                mainMiscellaneousOhm.value2 = 0.0
            }
        }

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