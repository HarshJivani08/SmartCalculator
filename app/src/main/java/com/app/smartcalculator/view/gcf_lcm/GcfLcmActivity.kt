package com.app.smartcalculator.view.gcf_lcm
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityGcfLcmBinding

class GcfLcmActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityGcfLcmBinding? = null

    var ans1 = 0
    var ans2 = 0
    var value1 = 0
    var value2 = 0

    private fun gcf(i: Int, i2: Int): Int {
        var i = i
        var i2 = i2
        while (i != i2) {
            if (i > i2) {
                i -= i2
            } else {
                i2 -= i
            }
        }
        return i
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGcfLcmBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.gcf)
    }

    @SuppressLint("SetTextI18n")
    private fun calculateValue() {
        if (binding?.editTextGl1?.text.toString().isEmpty()) {
            binding?.editTextGl1?.error = "Input value 1."
            binding?.editTextGl1?.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextGl2?.text.toString().isEmpty()) {
            binding?.editTextGl2?.error = "Input value 2."
            binding?.editTextGl2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                this.value1 = binding?.editTextGl1?.text.toString().toInt()
                this.value2 = binding?.editTextGl2?.text.toString().toInt()
                this.ans1 = this.gcf(this.value1, this.value2)
                this.ans2 = this.lcm(this.value1, this.value2)
                val editText: EditText = binding?.editTextGl3!!
                editText.setText(this.ans1.toString() + "")
                val editText2: EditText = binding?.editTextGl4!!
                editText2.setText(this.ans2.toString() + "")
            } catch (e: NumberFormatException) {
                val gcfLcm: GcfLcmActivity = this
                gcfLcm.value1 = 0
                gcfLcm.value2 = 0
            }
        }
    }

    private fun clearValue() {
        if (binding?.editTextGl1?.requestFocus() == true || binding?.editTextGl2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextGl2?.setText("")
        binding?.editTextGl1?.setText("")
        binding?.editTextGl3?.setText("")
        binding?.editTextGl4?.setText("")
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

    private fun lcm(i: Int, i2: Int): Int {
        return i * i2 / gcf(i, i2)
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

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

}