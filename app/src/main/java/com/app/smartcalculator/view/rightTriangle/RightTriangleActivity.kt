package com.app.smartcalculator.view.rightTriangle
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityRightTriangleBinding
import java.text.DecimalFormat
import kotlin.math.hypot
import kotlin.math.sqrt

class RightTriangleActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityRightTriangleBinding? = null

    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRightTriangleBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.toolbar?.title?.text = getString(R.string.right_triangle)
        setClick()
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input side a."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input side b."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                val sqrt: Double =
                    value1 + value2 + sqrt(
                        value1 * value1 + value2 * value2
                    )
                binding?.edt3?.setText(
                    decimalFormat.format(
                        hypot(
                            value1,
                            value2
                        )
                    )
                )
                binding?.edt4?.setText(decimalFormat.format(value2 * value1 / 2.0))
                binding?.edt5?.setText(decimalFormat.format(sqrt))
            } catch (e: NumberFormatException) {
                val mainGeometryRightTriangle = this
                mainGeometryRightTriangle.value1 = 0.0
                mainGeometryRightTriangle.value2 = 0.0
            }
        }
    }


    fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt2?.setText("")
        binding?.edt1?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
        binding?.edt5?.setText("")
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