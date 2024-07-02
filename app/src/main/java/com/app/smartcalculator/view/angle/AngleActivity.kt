package com.app.smartcalculator.view.angle

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityAngleBinding
import java.text.DecimalFormat


class AngleActivity : BaseActivity(), View.OnClickListener {

    var ans1 = 0.0
    var ans2 = 0.0
    var ans3 = 0.0
    var ans4 = 0.0
    var ans5 = 0.0
    var id = 0
    var value = 0.0
    val decimal = DecimalFormat("###.##")


    private var binding: ActivityAngleBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAngleBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.angle)

    }

    private fun setClick() {
        binding?.editTextAngle1?.setOnClickListener(this)
        binding?.editTextAngle2?.setOnClickListener(this)
        binding?.editTextAngle3?.setOnClickListener(this)
        binding?.editTextAngle4?.setOnClickListener(this)
        binding?.editTextAngle5?.setOnClickListener(this)
        binding?.editTextAngle6?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }


    private fun setUpDialog() {
        val dialog = Dialog(this,R.style.MyAlertDialogTheme)
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
            R.id.editText_angle1 -> {
                degreeConversion(d)
                return
            }
            R.id.editText_angle2 -> {
                radianConversion(d)
                return
            }
            R.id.editText_angle3 -> {
                gradConversion(d)
                return
            }
            R.id.editText_angle4 -> {
                revolutionConversion(d)
                return
            }
            R.id.editText_angle5 -> {
                circleConversion(d)
                return
            }
            R.id.editText_angle6 -> {
                milConversion(d)
                return
            }
            else -> return
        }
    }


    private fun degreeConversion(d: Double) {
        binding?.editTextAngle1?.setText(d.toString())
        val d2 = 0.01745329 * d
        ans1 = d2
        ans2 = 1.111111 * d
        val d22 = 0.002778 * d
        ans3 = d22
        ans4 = d22
        ans5 = 17.777778 * d
        binding?.editTextAngle2?.setText(this.decimal.format(d2))
        binding?.editTextAngle3?.setText(this.decimal.format(ans2))
        binding?.editTextAngle4?.setText(this.decimal.format(ans3))
        binding?.editTextAngle5?.setText(this.decimal.format(ans4))
        binding?.editTextAngle6?.setText(this.decimal.format(ans5))
    }


    private fun radianConversion(d: Double) {
        binding?.editTextAngle2?.setText(d.toString())
        val d2 = 57.29578 * d
        ans1 = d2
        ans2 = 63.661977 * d
        val d22 = 0.159155 * d
        ans3 = d22
        ans4 = d22
        ans5 = 1018.591636 * d
        binding?.editTextAngle1?.setText(decimal.format(d2))
        binding?.editTextAngle3?.setText(decimal.format(ans2))
        binding?.editTextAngle4?.setText(decimal.format(ans3))
        binding?.editTextAngle5?.setText(decimal.format(ans4))
        binding?.editTextAngle6?.setText(decimal.format(ans5))
    }


    private fun gradConversion(d: Double) {
        binding?.editTextAngle3?.setText(d.toString())
        val d2 = 0.9 * d
        ans1 = d2
        ans2 = 0.015708 * d
        val d22 = 0.0025 * d
        ans3 = d22
        ans4 = d22
        ans5 = 16.0 * d
        binding?.editTextAngle1?.setText(decimal.format(d2))
        binding?.editTextAngle2?.setText(decimal.format(ans2))
        binding?.editTextAngle4?.setText(decimal.format(ans3))
        binding?.editTextAngle5?.setText(decimal.format(ans4))
        binding?.editTextAngle6?.setText(decimal.format(ans5))
    }


    private fun revolutionConversion(d: Double) {
        binding?.editTextAngle4?.setText(d.toString())
        val d2 = 360.0 * d
        ans1 = d2
        ans2 = 6.283185 * d
        ans3 = 400.0 * d
        ans4 = 1.0 * d
        ans5 = 6400.0 * d
        binding?.editTextAngle1?.setText(decimal.format(d2))
        binding?.editTextAngle2?.setText(decimal.format(ans2))
        binding?.editTextAngle3?.setText(decimal.format(ans3))
        binding?.editTextAngle5?.setText(decimal.format(ans4))
        binding?.editTextAngle6?.setText(decimal.format(ans5))
    }


    private fun circleConversion(d: Double) {
        binding?.editTextAngle5?.setText(d.toString())
        val d2 = 360.0 * d
        ans1 = d2
        ans2 = 6.283185 * d
        ans3 = 400.0 * d
        ans4 = 1.0 * d
        ans5 = 6400.0 * d
        binding?.editTextAngle1?.setText(decimal.format(d2))
        binding?.editTextAngle2?.setText(decimal.format(ans2))
        binding?.editTextAngle3?.setText(decimal.format(ans3))
        binding?.editTextAngle4?.setText(decimal.format(ans4))
        binding?.editTextAngle6?.setText(decimal.format(ans5))
    }

    private fun milConversion(d: Double) {
        binding?.editTextAngle6?.setText(d.toString())
        val d2 = 0.05625 * d
        ans1 = d2
        ans2 = 9.82E-4 * d
        ans3 = 0.0625 * d
        val d22 = 1.56E-4 * d
        ans4 = d22
        ans5 = d22
        binding?.editTextAngle1?.setText(decimal.format(d2))
        binding?.editTextAngle2?.setText(decimal.format(ans2))
        binding?.editTextAngle3?.setText(decimal.format(ans3))
        binding?.editTextAngle4?.setText(decimal.format(ans4))
        binding?.editTextAngle5?.setText(decimal.format(ans5))
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!
        when (p0.id) {
            R.id.editText_angle1 -> {
                setUpDialog()
            }
            R.id.editText_angle2 -> {
                setUpDialog()
            }
            R.id.editText_angle3 -> {
                setUpDialog()
            }
            R.id.editText_angle4 -> {
                setUpDialog()
            }
            R.id.editText_angle5 -> {
                setUpDialog()
            }
            R.id.editText_angle6 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextAngle1?.setText("")
                binding?.editTextAngle2?.setText("")
                binding?.editTextAngle3?.setText("")
                binding?.editTextAngle4?.setText("")
                binding?.editTextAngle5?.setText("")
                binding?.editTextAngle6?.setText("")
            }

            R.id.back_img -> {
                onBackPressed()
            }
        }
    }

}