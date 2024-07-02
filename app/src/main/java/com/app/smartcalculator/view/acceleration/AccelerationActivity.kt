package com.app.smartcalculator.view.acceleration

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R

import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityAccelerationBinding


import java.text.DecimalFormat

class AccelerationActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityAccelerationBinding? = null
    var ans1 = 0.0
    var ans2 = 0.0
    var ans3 = 0.0
    val decimal = DecimalFormat("###.##")
    var id = 0
    var value = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccelerationBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.acceleration)

    }



    private fun setUpDialog() {
        val dialog = Dialog(this, R.style.MyAlertDialogTheme).apply {
            setContentView(R.layout.user_input_dialoge)
        }
        val editText = dialog.findViewById<View>(R.id.input_value) as EditText
        dialog.findViewById<View>(R.id.done).setOnClickListener {
            try {
                value = editText.text.toString().toDouble()
                convertMethod(value)
            } catch (e: NumberFormatException) {
                value = 0.0
            }
            editText.text.clear()
            dialog.dismiss()
        }
        dialog.show()
    }

    fun convertMethod(d: Double) {
        when (id) {
            R.id.editText_ua1 -> {
                meterConversion(d)
                return
            }
            R.id.editText_ua2 -> {
                footConversion(d)
                return
            }
            R.id.editText_ua3 -> {
                gravityConversion(d)
                return
            }
            R.id.editText_ua4 -> {
                galConversion(d)
                return
            }
            else -> return
        }
    }

    private fun galConversion(d: Double) {
        binding?.editTextUa4?.setText(d.toString())
        val d2 = 0.01 * d
        ans1 = d2
        ans2 = 0.03280839895 * d
        ans3 = 0.001019716213 * d
        binding?.editTextUa1?.setText(decimal.format(d2))
        binding?.editTextUa2?.setText(decimal.format(ans2))
        binding?.editTextUa3?.setText(decimal.format(ans3))
    }

    private fun gravityConversion(d: Double) {
        binding?.editTextUa3?.setText(d.toString())
        val d2 = 9.806649999788 * d
        ans1 = d2
        ans2 = 32.17404855561 * d
        ans3 = 980.6649999788 * d
        binding?.editTextUa1?.setText(decimal.format(d2))
        binding?.editTextUa2?.setText(decimal.format(ans2))
        binding?.editTextUa4?.setText(decimal.format(ans3))
    }


    private fun footConversion(d: Double) {
        binding?.editTextUa2?.setText(d.toString())
        val d2 = d / 3.28084
        ans1 = d2
        ans2 = 0.03108095017236 * d
        ans3 = 30.48 * d
        binding?.editTextUa1?.setText(decimal.format(d2))
        binding?.editTextUa3?.setText(decimal.format(ans2))
        binding?.editTextUa4?.setText(decimal.format(ans3))
    }

    private fun meterConversion(d: Double) {
        binding?.editTextUa1?.setText(d.toString())
        val d2 = 3.28084 * d
        ans1 = d2
        ans2 = d / 9.80665
        ans3 = 100.0 * d
        binding?.editTextUa2?.setText(decimal.format(d2))
        binding?.editTextUa3?.setText(decimal.format(ans2))
        binding?.editTextUa4?.setText(decimal.format(ans3))
    }

    private fun setClick() {
        binding?.editTextUa1?.setOnClickListener(this)
        binding?.editTextUa2?.setOnClickListener(this)
        binding?.editTextUa3?.setOnClickListener(this)
        binding?.editTextUa4?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        id = p0!!.id

        when (p0.id) {
            R.id.editText_ua1 -> {
                setUpDialog()
            }
            R.id.editText_ua2 -> {
                setUpDialog()
            }
            R.id.editText_ua3 -> {
                setUpDialog()
            }
            R.id.editText_ua4 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextUa1?.setText("")
                binding?.editTextUa2?.setText("")
                binding?.editTextUa3?.setText("")
                binding?.editTextUa4?.setText("")
            }
            R.id.back_img -> {
                onBackPressed()
            }

        }


    }

}