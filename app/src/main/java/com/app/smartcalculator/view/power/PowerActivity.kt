package com.app.smartcalculator.view.power

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityPowerBinding
import java.text.DecimalFormat

class PowerActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityPowerBinding? = null

    private var ans1 = 0.0
    private var ans2 = 0.0
    private var ans3 = 0.0
    private var ans4 = 0.0
    private var ans5 = 0.0
    private val decimal = DecimalFormat("###.##")
    private var id = 0
    private var value = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPowerBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.power)
    }

    private fun setClick() {
        binding?.editTextPower6?.setOnClickListener(this)
        binding?.editTextPower5?.setOnClickListener(this)
        binding?.editTextPower4?.setOnClickListener(this)
        binding?.editTextPower3?.setOnClickListener(this)
        binding?.editTextPower2?.setOnClickListener(this)
        binding?.editTextPower1?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_power1 -> {
                setUpDialog()
            }
            R.id.editText_power2 -> {
                setUpDialog()
            }
            R.id.editText_power3 -> {
                setUpDialog()
            }
            R.id.editText_power4 -> {
                setUpDialog()
            }
            R.id.editText_power5 -> {
                setUpDialog()
            }
            R.id.editText_power6 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextPower6?.setText("")
                binding?.editTextPower5?.setText("")
                binding?.editTextPower4?.setText("")
                binding?.editTextPower3?.setText("")
                binding?.editTextPower2?.setText("")
                binding?.editTextPower1?.setText("")
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
            R.id.editText_power1 -> {
                megawattConversion(d)
                return
            }
            R.id.editText_power2 -> {
                gigawattConversion(d)
                return
            }
            R.id.editText_power3 -> {
                kilowattConversion(d)
                return
            }
            R.id.editText_power4 -> {
                wattConversion(d)
                return
            }
            R.id.editText_power5 -> {
                miliwattConversion(d)
                return
            }
            R.id.editText_power6 -> {
                horsepowerConversion(d)
                return
            }
            else -> return
        }
    }


    private fun horsepowerConversion(d: Double) {
        binding?.editTextPower6?.setText(d.toString())
        val d2 = 7.456998715823E-4 * d
        ans1 = d2
        ans2 = 7.456998715823E-7 * d
        ans3 = 0.7456998715823 * d
        ans4 = 745.6998715823 * d
        ans5 = 745699.8715823 * d
        binding?.editTextPower1?.setText(decimal.format(d2))
        binding?.editTextPower2?.setText(decimal.format(ans2))
        binding?.editTextPower3?.setText(decimal.format(ans3))
        binding?.editTextPower4?.setText(decimal.format(ans4))
        binding?.editTextPower5?.setText(decimal.format(ans5))
    }

    private fun miliwattConversion(d: Double) {
        binding?.editTextPower5?.setText(d.toString())
        val d2 = 1.0E-9 * d
        ans1 = d2
        ans2 = 1.0E-12 * d
        ans3 = 1.0E-6 * d
        ans4 = 0.001 * d
        ans5 = 1.341022089595E-6 * d
        binding?.editTextPower1?.setText(decimal.format(d2))
        binding?.editTextPower2?.setText(decimal.format(ans2))
        binding?.editTextPower3?.setText(decimal.format(ans3))
        binding?.editTextPower4?.setText(decimal.format(ans4))
        binding?.editTextPower6?.setText(decimal.format(ans5))
    }

    private fun wattConversion(d: Double) {
        binding?.editTextPower4?.setText(d.toString())
        val d2 = 1.0E-6 * d
        ans1 = d2
        ans2 = 1.0E-9 * d
        ans3 = 0.001 * d
        ans4 = 1000.0 * d
        ans5 = 0.001341022089595 * d
        binding?.editTextPower1?.setText(decimal.format(d2))
        binding?.editTextPower2?.setText(decimal.format(ans2))
        binding?.editTextPower3?.setText(decimal.format(ans3))
        binding?.editTextPower5?.setText(decimal.format(ans4))
        binding?.editTextPower6?.setText(decimal.format(ans5))
    }

    private fun kilowattConversion(d: Double) {
        binding?.editTextPower3?.setText(d.toString())
        val d2 = 0.001 * d
        ans1 = d2
        ans2 = 1.0E-6 * d
        ans3 = 1000.0 * d
        ans4 = 1000000.0 * d
        ans5 = 1.341022089595 * d
        binding?.editTextPower1?.setText(decimal.format(d2))
        binding?.editTextPower2?.setText(decimal.format(ans2))
        binding?.editTextPower4?.setText(decimal.format(ans3))
        binding?.editTextPower5?.setText(decimal.format(ans4))
        binding?.editTextPower6?.setText(decimal.format(ans5))
    }

    private fun gigawattConversion(d: Double) {
        binding?.editTextPower2?.setText(d.toString())
        val d2 = 1000.0 * d
        ans1 = d2
        ans2 = 1000000.0 * d
        ans3 = 1.0E9 * d
        ans4 = 1.0E12 * d
        ans5 = 1341022.089595 * d
        binding?.editTextPower1?.setText(decimal.format(d2))
        binding?.editTextPower3?.setText(decimal.format(ans2))
        binding?.editTextPower4?.setText(decimal.format(ans3))
        binding?.editTextPower5?.setText(decimal.format(ans4))
        binding?.editTextPower6?.setText(decimal.format(ans5))
    }

    private fun megawattConversion(d: Double) {
        binding?.editTextPower1?.setText(d.toString())
        val d2 = 0.001 * d
        ans1 = d2
        ans2 = 1000.0 * d
        ans3 = 1000000.0 * d
        ans4 = 1.0E9 * d
        ans5 = 1341.022089595 * d
        binding?.editTextPower2?.setText(decimal.format(d2))
        binding?.editTextPower3?.setText(decimal.format(ans2))
        binding?.editTextPower4?.setText(decimal.format(ans3))
        binding?.editTextPower5?.setText(decimal.format(ans4))
        binding?.editTextPower6?.setText(decimal.format(ans5))
    }



}