package com.app.smartcalculator.view.heron
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityHeronBinding
import java.text.DecimalFormat
import kotlin.math.sqrt

class HeronActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityHeronBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeronBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.heron)
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
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt2!!.setText("")
        binding?.edt1!!.setText("")
        binding?.edt3!!.setText("")
        binding?.edt4!!.setText("")
        binding?.edt5!!.setText("")
        binding?.edt6!!.setText("")
        binding?.edt7!!.setText("")
        binding?.edt8!!.setText("")
    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input side a."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input side b."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input side c."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edt2?.text.toString().toDouble()
                value3 = binding?.edt3?.text.toString().toDouble()
                val d: Double =
                    (value1 + value2 + value3) / 2.0
                val d2: Double =
                    value1 + value2 + value3
                val sqrt: Double =
                    2.0 / value1 * sqrt((d - value1) * d * (d - value2) * (d - value3))
                val sqrt2: Double =
                    2.0 / value2 * sqrt((d - value1) * d * (d - value2) * (d - value3))
                binding?.edt4?.setText(decimalFormat.format(sqrt((d - value1) * d * (d - value2) * (d - value3))))
                binding?.edt5?.setText(decimalFormat.format(d2))
                binding?.edt6?.setText(decimalFormat.format(sqrt))
                binding?.edt7?.setText(decimalFormat.format(sqrt2))
                binding?.edt8?.setText(
                    decimalFormat.format(
                        2.0 / value3 * sqrt(
                            (d - value1) * d * (d - value2) * (d - value3)
                        )
                    )
                )
            } catch (e: NumberFormatException) {
                val mainGeometryHerons = this
                mainGeometryHerons.value1 = 0.0
                mainGeometryHerons.value2 = 0.0
                mainGeometryHerons.value3 = 0.0
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