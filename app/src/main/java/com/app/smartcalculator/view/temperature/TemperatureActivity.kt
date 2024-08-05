package com.app.smartcalculator.view.temperature

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityTemperatureBinding
import java.text.DecimalFormat

class TemperatureActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityTemperatureBinding? = null

    private var ans1 = 0.0
    private var ans2 = 0.0
    private val decimal = DecimalFormat("###.##")
    private var id = 0
    private var value = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.temperature)
    }

    private fun setClick() {
        binding?.editTextTemp1?.setOnClickListener(this)
        binding?.editTextTemp2?.setOnClickListener(this)
        binding?.editTextTemp3?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_temp1 -> {
                setUpDialog()
            }
            R.id.editText_temp2 -> {
                setUpDialog()
            }
            R.id.editText_temp3 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextTemp1?.setText("")
                binding?.editTextTemp2?.setText("")
                binding?.editTextTemp3?.setText("")
            }
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun setUpDialog() {
        val dialog = Dialog(this, R.style.MyAlertDialogTheme)
        dialog.setContentView(R.layout.user_input_dialoge)
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
            R.id.editText_temp1 -> {
                celsiusConversion(d)
                return
            }
            R.id.editText_temp2 -> {
                fahrenheitConversion(d)
                return
            }
            R.id.editText_temp3 -> {
                kelvineConversion(d)
                return
            }
            else -> return
        }
    }

    private fun kelvineConversion(d: Double) {
        binding?.editTextTemp3?.setText(d.toString())
        val d2 = d - 273.15
        ans1 = d2
        ans2 = 9.0 * d2 / 5.0 + 32.0
        binding?.editTextTemp1?.setText(decimal.format(d2))
        binding?.editTextTemp2?.setText(decimal.format(ans2))
    }

    private fun fahrenheitConversion(d: Double) {
        binding?.editTextTemp2?.setText(d.toString())
        val d2 = (d - 32.0) * 5.0 / 9.0
        ans1 = d2
        ans2 = 273.15 + d2
        binding?.editTextTemp1?.setText(decimal.format(d2))
        binding?.editTextTemp3?.setText(decimal.format(ans2))
    }

    private fun celsiusConversion(d: Double) {
        binding?.editTextTemp1?.setText(d.toString())
        val d2 = 9.0 * d / 5.0 + 32.0
        ans1 = d2
        ans2 = 273.15 + d
        binding?.editTextTemp2?.setText(decimal.format(d2))
        binding?.editTextTemp3?.setText(decimal.format(ans2))
    }



}