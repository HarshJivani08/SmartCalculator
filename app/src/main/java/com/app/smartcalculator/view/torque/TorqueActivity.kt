package com.app.smartcalculator.view.torque

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityTorqueBinding
import java.text.DecimalFormat

class TorqueActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityTorqueBinding? = null

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
        binding = ActivityTorqueBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()

        binding?.toolbar?.title?.text = getString(R.string.torque)
    }

    private fun setClick() {
        binding?.editTextTorque6?.setOnClickListener(this)
        binding?.editTextTorque5?.setOnClickListener(this)
        binding?.editTextTorque4?.setOnClickListener(this)
        binding?.editTextTorque3?.setOnClickListener(this)
        binding?.editTextTorque2?.setOnClickListener(this)
        binding?.editTextTorque1?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_torque1 -> {
                setUpDialog()
            }
            R.id.editText_torque2 -> {
                setUpDialog()
            }
            R.id.editText_torque3 -> {
                setUpDialog()
            }
            R.id.editText_torque4 -> {
                setUpDialog()
            }
            R.id.editText_torque5 -> {
                setUpDialog()
            }
            R.id.editText_torque6 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextTorque1?.setText("")
                binding?.editTextTorque2?.setText("")
                binding?.editTextTorque3?.setText("")
                binding?.editTextTorque4?.setText("")
                binding?.editTextTorque5?.setText("")
                binding?.editTextTorque6?.setText("")
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
            R.id.editText_torque1 -> {
                newtonmeterConversion(d)
                return
            }
            R.id.editText_torque2 -> {
                newtoncentimeterConversion(d)
                return
            }
            R.id.editText_torque3 -> {
                meterkilogramConversion(d)
                return
            }
            R.id.editText_torque4 -> {
                foodpoundforceConversion(d)
                return
            }
            R.id.editText_torque5 -> {
                dynemeterConversion(d)
                return
            }
            R.id.editText_torque6 -> {
                inchpoundforceConversion(d)
                return
            }
            else -> return
        }
    }


    private fun inchpoundforceConversion(d: Double) {
        binding?.editTextTorque6?.setText(d.toString())
        val d2 = 0.1129848293305 * d
        ans1 = d2
        ans2 = 11.29848293305 * d
        ans3 = 0.01152124622889 * d
        ans4 = 0.08333333333107 * d
        ans5 = 11298.48293305 * d
        binding?.editTextTorque1?.setText(decimal.format(d2))
        binding?.editTextTorque2?.setText(decimal.format(ans2))
        binding?.editTextTorque3?.setText(decimal.format(ans3))
        binding?.editTextTorque4?.setText(decimal.format(ans4))
        binding?.editTextTorque5?.setText(decimal.format(ans5))
    }

    private fun dynemeterConversion(d: Double) {
        binding?.editTextTorque5?.setText(d.toString())
        val d2 = 1.0E-5 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 1.019716212978E-6 * d
        ans4 = 7.3756214728E-6 * d
        ans5 = 8.8507457676E-5 * d
        binding?.editTextTorque1?.setText(decimal.format(d2))
        binding?.editTextTorque2?.setText(decimal.format(ans2))
        binding?.editTextTorque3?.setText(decimal.format(ans3))
        binding?.editTextTorque4?.setText(decimal.format(ans4))
        binding?.editTextTorque6?.setText(decimal.format(ans5))
    }

    private fun foodpoundforceConversion(d: Double) {
        binding?.editTextTorque4?.setText(d.toString())
        val d2 = 1.355817952003 * d
        ans1 = d2
        ans2 = 135.5817952003 * d
        ans3 = 0.1382549547504 * d
        ans4 = 135581.7952003 * d
        ans5 = 12.00000000033 * d
        binding?.editTextTorque1?.setText(decimal.format(d2))
        binding?.editTextTorque2?.setText(decimal.format(ans2))
        binding?.editTextTorque3?.setText(decimal.format(ans3))
        binding?.editTextTorque5?.setText(decimal.format(ans4))
        binding?.editTextTorque6?.setText(decimal.format(ans5))
    }

    private fun meterkilogramConversion(d: Double) {
        binding?.editTextTorque3?.setText(d.toString())
        val d2 = 9.80665 * d
        ans1 = d2
        ans2 = 980.665 * d
        ans3 = 7.233013831624 * d
        ans4 = 980665.0 * d
        ans5 = 86.79616598184 * d
        binding?.editTextTorque1?.setText(decimal.format(d2))
        binding?.editTextTorque2?.setText(decimal.format(ans2))
        binding?.editTextTorque4?.setText(decimal.format(ans3))
        binding?.editTextTorque5?.setText(decimal.format(ans4))
        binding?.editTextTorque6?.setText(decimal.format(ans5))
    }

    private fun newtoncentimeterConversion(d: Double) {
        binding?.editTextTorque2?.setText(d.toString())
        val d2 = 0.01 * d
        ans1 = d2
        ans2 = 0.001019716212978 * d
        ans3 = 0.0073756214728 * d
        ans4 = 1000.0 * d
        ans5 = 0.088507457676 * d
        binding?.editTextTorque1?.setText(decimal.format(d2))
        binding?.editTextTorque3?.setText(decimal.format(ans2))
        binding?.editTextTorque4?.setText(decimal.format(ans3))
        binding?.editTextTorque5?.setText(decimal.format(ans4))
        binding?.editTextTorque6?.setText(decimal.format(ans5))
    }

    private fun newtonmeterConversion(d: Double) {
        binding?.editTextTorque1?.setText(d.toString())
        val d2 = 100.0 * d
        ans1 = d2
        ans2 = 0.1019716212978 * d
        ans3 = 0.73756214728 * d
        ans4 = 100000.0 * d
        ans5 = 8.8507457676 * d
        binding?.editTextTorque2?.setText(decimal.format(d2))
        binding?.editTextTorque3?.setText(decimal.format(ans2))
        binding?.editTextTorque4?.setText(decimal.format(ans3))
        binding?.editTextTorque5?.setText(decimal.format(ans4))
        binding?.editTextTorque6?.setText(decimal.format(ans5))
    }

}