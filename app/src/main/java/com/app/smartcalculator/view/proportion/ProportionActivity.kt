package com.app.smartcalculator.view.proportion
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityProportionBinding
import java.text.DecimalFormat

class ProportionActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityProportionBinding? = null
    var proRatio = 0.0
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProportionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.proportion)
    }

    fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.directlyBtn?.setOnClickListener(this)
        binding?.indirectlyBtn?.setOnClickListener(this)
        binding?.clearBtn?.setOnClickListener(this)
    }


    private fun calculateValueDirectly() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input value."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input value."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.edt1?.text.toString().toDouble()
                value2 = binding?.edt2?.text.toString().toDouble()
                value3 = binding?.edt3?.text.toString().toDouble()
                proRatio = value3 * value2 / value1
                binding?.ans?.text = decimalFormat.format(proRatio)
            } catch (e: NumberFormatException) {
                val proportionRatio: ProportionActivity = this
                proportionRatio.value1 = 0.0
                proportionRatio.value2 = 0.0
                proportionRatio.value3 = 0.0
            }
        }
    }

    private fun calculateValueIndirectly() {
        if (binding?.edt1!!.text.toString().isEmpty()) {
            binding?.edt1!!.error = "Input value."
            binding?.edt1!!.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2!!.text.toString().isEmpty()) {
            binding?.edt2!!.error = "Input value."
            binding?.edt2!!.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3!!.text.toString().isEmpty()) {
            binding?.edt3!!.error = "Input value."
            binding?.edt3!!.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 =
                    binding?.edt1!!.text.toString().toDouble()
                value2 = binding?.edt2!!.text.toString().toDouble()
                value3 = binding?.edt3!!.text.toString().toDouble()
                binding?.ans!!.text = decimalFormat.format(value1 * value3 / value2)
            } catch (e: NumberFormatException) {

                val proportionRatio: ProportionActivity = this
                proportionRatio.value1 = 0.0
                proportionRatio.value2 = 0.0
                proportionRatio.value3 = 0.0
            }
        }
    }

    fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.ans!!.text = ""
        binding?.edt2!!.setText("")
        binding?.edt1!!.setText("")
        binding?.edt3!!.setText("")
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
            R.id.clear_btn -> {
                clearValue()
            }
            R.id.directly_btn -> {
                calculateValueDirectly()
            }
            R.id.indirectly_btn -> {
                calculateValueIndirectly()
            }
        }
    }

}