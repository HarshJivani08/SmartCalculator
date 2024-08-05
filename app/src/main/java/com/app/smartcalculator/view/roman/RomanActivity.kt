package com.app.smartcalculator.view.roman

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityRomanBinding
import java.util.*

class RomanActivity : BaseActivity(), View.OnClickListener {

    private var id = 0
    private var value = ""

    private fun processDecimal(i: Int, i2: Int, i3: Int): Int {
        return if (i2 > i) i3 - i else i3 + i
    }


    private var binding: ActivityRomanBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRomanBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.roman)
        setClick()
    }


    private fun setUpDialog() {
        val dialog = Dialog(this, R.style.MyAlertDialogTheme)
        dialog.setContentView(R.layout.user_input_dialoge)
        val editText = dialog.findViewById<View>(R.id.input_value) as EditText
        dialog.findViewById<View>(R.id.done).setOnClickListener {
            try {
                value = editText.text.toString()
                convertMethod(value)
            } catch (e: Exception) {
                value = ""
            }
            editText.text.clear()
            dialog.dismiss()
        }
        dialog.show()
    }

    fun convertMethod(str: String) {
        if (id == R.id.editText_roman1) {
            numberConversion(str.toInt())
        }
//        else if (id == R.id.editText_roman2) {
//            romanNumberConversion(str)
//        }
    }

    @SuppressLint("SetTextI18n")
    private fun numberConversion(i: Int) {
        binding?.editTextRoman1?.setText(i.toString())
        val strArr = arrayOf("", "M", "MM", "MMM")
        val strArr2 = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val strArr3 = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val strArr4 = arrayOf(
            "",
            "I",
            "II",
            "III",
            "IV",
            "V",
            "VI",
            "VII",
            "VIII",
            "IX",
            "X"
        )
        if (i <= 3999) {
            val editText: TextView = binding?.editTextRoman2!!
            editText.setText(strArr[i / 1000] + strArr2[i / 100 % 10] + strArr3[i / 10 % 10] + strArr4[i % 10] + "")
            return
        }
        Toast.makeText(applicationContext, "Less than 4000", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("SetTextI18n")
    private fun romanNumberConversion(str: String) {
        binding?.editTextRoman2?.setText(str)
        val intValue: Int = romanToDecimal(str)!!.toInt()
        val editText: EditText = binding?.editTextRoman1!!
        editText.setText(intValue.toString())
    }

    private fun romanToDecimal(str: String): Int? {
        val upperCase = str.uppercase(Locale.getDefault())
        var i = 0
        var i2 = 0
        for (length in upperCase.length - 1 downTo 0) {
            when (upperCase[length]) {
                'C' -> {
                    i = processDecimal(
                        100,
                        i2,
                        i
                    )
                    i2 = 100
                }
                'D' -> {
                    i = processDecimal(
                        500,
                        i2,
                        i
                    )
                    i2 = 500
                }
                'I' -> {
                    i = processDecimal(
                        1,
                        i2,
                        i
                    )
                    i2 = 1
                }
                'V' -> {
                    i = processDecimal(
                        5,
                        i2,
                        i
                    )
                    i2 = 5
                }
                'X' -> {
                    i = processDecimal(
                        10,
                        i2,
                        i
                    )
                    i2 = 10
                }
                'L' -> {
                    i = processDecimal(
                        50,
                        i2,
                        i
                    )
                    i2 = 50
                }
                'M' -> {
                    i = processDecimal(
                        1000,
                        i2,
                        i
                    )
                    i2 = 1000
                }
            }
        }
        return Integer.valueOf(i)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_roman1 -> {
                setUpDialog()
            }
            R.id.back_img -> {
              onBackPressedDispatcher.onBackPressed()
            }

            R.id.clear -> {
                binding?.editTextRoman1?.setText("")
                binding?.editTextRoman2?.setText("")
            }
        }
    }

    fun setClick() {
        binding?.editTextRoman1?.setOnClickListener(this)
        binding?.editTextRoman2?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
    }



}