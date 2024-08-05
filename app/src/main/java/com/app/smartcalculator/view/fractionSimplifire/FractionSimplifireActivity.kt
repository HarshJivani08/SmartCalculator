package com.app.smartcalculator.view.fractionSimplifire
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityFractionSimplifireBinding


class FractionSimplifireActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityFractionSimplifireBinding? = null

    var ans = 0.0
    var value1 = 0.0
    var value2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFractionSimplifireBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.fraction_to_decimal)

    }

    fun clearValue() {
        if (binding?.editTextFd1?.requestFocus()!! || binding?.editTextFd2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextFd2!!.setText("")
        binding?.editTextFd1!!.setText("")
        binding?.editTextFd3!!.setText("")
    }

    fun calculateValue() {
        if (binding?.editTextFd1?.text.toString().isEmpty()) {
            binding?.editTextFd1?.error = "Input value."
            binding?.editTextFd1?.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextFd2?.text.toString().isEmpty()) {
            binding?.editTextFd2?.error = "Input value."
            binding?.editTextFd2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.editTextFd1?.text.toString().toDouble()
                value2 = binding?.editTextFd2?.text.toString().toDouble()
                ans = value1 / value2
                val editText: EditText = binding?.editTextFd3!!
                editText.setText(ans.toString() + "")
            } catch (e: NumberFormatException) {
                val fraction_To_Decimal: FractionSimplifireActivity = this
                fraction_To_Decimal.value1 = 0.0
                fraction_To_Decimal.value2 = 0.0
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

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }



}