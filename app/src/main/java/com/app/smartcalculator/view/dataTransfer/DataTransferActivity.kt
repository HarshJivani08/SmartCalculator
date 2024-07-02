package com.app.smartcalculator.view.dataTransfer

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityDataTransferBinding
import java.text.DecimalFormat

class DataTransferActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityDataTransferBinding? = null

    private var ans1 = 0.0
    private var ans2 = 0.0
    private var ans3 = 0.0
    private var ans4 = 0.0
    private var ans5 = 0.0
    private var ans6 = 0.0
    private var ans7 = 0.0
    private var ans8 = 0.0
    private var ans9 = 0.0
    private val decimal = DecimalFormat("###.##")
    private var id = 0
    private var value = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataTransferBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.data_transfer)
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
            R.id.editText_data1 -> {
                byteConversion(d)
                return
            }
            R.id.editText_data10 -> {
                terabitConversion(d)
                return
            }
            R.id.editText_data2 -> {
                kilobyteConversion(d)
                return
            }
            R.id.editText_data3 -> {
                megabyteConversion(d)
                return
            }
            R.id.editText_data4 -> {
                gigabyteConversion(d)
                return
            }
            R.id.editText_data5 -> {
                terabyteConversion(d)
                return
            }
            R.id.editText_data6 -> {
                bitConversion(d)
                return
            }
            R.id.editText_data7 -> {
                kilobitConversion(d)
                return
            }
            R.id.editText_data8 -> {
                megabitConversion(d)
                return
            }
            R.id.editText_data9 -> {
                gigabitConversion(d)
                return
            }
            else -> return
        }
    }


    private fun byteConversion(d: Double) {
        binding?.editTextData1?.setText(d.toString())
        val d2 = 0.001 * d
        ans1 = d2
        ans2 = 1.0E-6 * d
        ans3 = 1.0E-9 * d
        ans4 = 1.0E-12 * d
        ans5 = 8.0 * d
        ans6 = 0.008 * d
        ans7 = 8.0E-6 * d
        ans8 = 8.0E-9 * d
        ans9 = 8.0E-12 * d
        binding?.editTextData2?.setText(decimal.format(d2))
        binding?.editTextData3?.setText(decimal.format(ans2))
        binding?.editTextData4?.setText(decimal.format(ans3))
        binding?.editTextData5?.setText(decimal.format(ans4))
        binding?.editTextData6?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun kilobyteConversion(d: Double) {
        binding?.editTextData2?.setText(d.toString())
        val d2 = 1000.0 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 1.0E-6 * d
        ans4 = 1.0E-9 * d
        ans5 = 8000.0 * d
        ans6 = 8.0 * d
        ans7 = 0.008 * d
        ans8 = 8.0E-6 * d
        ans9 = 8.0E-9 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData3?.setText(decimal.format(ans2))
        binding?.editTextData4?.setText(decimal.format(ans3))
        binding?.editTextData5?.setText(decimal.format(ans4))
        binding?.editTextData6?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }


    private fun megabyteConversion(d: Double) {
        binding?.editTextData3?.setText(d.toString())
        val d2 = 1000000.0 * d
        ans1 = d2
        ans2 = 1000.0 * d
        ans3 = 0.001 * d
        ans4 = 1.0E-6 * d
        ans5 = 8000000.0 * d
        ans6 = 8000.0 * d
        ans7 = 8.0 * d
        ans8 = 0.008 * d
        ans9 = 7.275957614183E-6 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData4?.setText(decimal.format(ans3))
        binding?.editTextData5?.setText(decimal.format(ans4))
        binding?.editTextData6?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun gigabyteConversion(d: Double) {
        binding?.editTextData4?.setText(d.toString())
        val d2 = 1.0E9 * d
        ans1 = d2
        ans2 = 1000000.0 * d
        ans3 = 1000.0 * d
        ans4 = 0.001 * d
        ans5 = 8.0E9 * d
        ans6 = 8000000.0 * d
        ans7 = 8000.0 * d
        ans8 = 8.0 * d
        ans9 = 0.008 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData5?.setText(decimal.format(ans4))
        binding?.editTextData6?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun terabyteConversion(d: Double) {
        binding?.editTextData5?.setText(d.toString())
        val d2 = 1.0E12 * d
        ans1 = d2
        ans2 = 1.0E9 * d
        ans3 = 1000000.0 * d
        ans4 = 1000.0 * d
        ans5 = 8.0E12 * d
        ans6 = 8.0E9 * d
        ans7 = 8000000.0 * d
        ans8 = 8000.0 * d
        ans9 = 8.0 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData6?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun bitConversion(d: Double) {
        binding?.editTextData6?.setText(d.toString())
        val d2 = 0.125 * d
        ans1 = d2
        ans2 = 1.25E-4 * d
        ans3 = 1.25E-7 * d
        ans4 = 1.25E-10 * d
        ans5 = 1.25E-13 * d
        ans6 = 0.001 * d
        ans7 = 1.0E-6 * d
        ans8 = 1.0E-9 * d
        ans9 = 1.0E-12 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData5?.setText(decimal.format(ans5))
        binding?.editTextData7?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun kilobitConversion(d: Double) {
        binding?.editTextData7?.setText(d.toString())
        val d2 = 125.0 * d
        ans1 = d2
        ans2 = 0.125 * d
        ans3 = 1.25E-4 * d
        ans4 = 1.25E-7 * d
        ans5 = 1.25E-10 * d
        ans6 = 1000.0 * d
        ans7 = 0.001 * d
        ans8 = 1.0E-6 * d
        ans9 = 1.0E-9 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData5?.setText(decimal.format(ans5))
        binding?.editTextData6?.setText(decimal.format(ans6))
        binding?.editTextData8?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun megabitConversion(d: Double) {
        binding?.editTextData8?.setText(d.toString())
        val d2 = 125000.0 * d
        ans1 = d2
        ans2 = 125.0 * d
        ans3 = 0.125 * d
        ans4 = 1.25E-4 * d
        val d22 = 1.0E-6 * d
        ans5 = d22
        ans6 = 1000000.0 * d
        ans7 = 1000.0 * d
        ans8 = 0.001 * d
        ans9 = d22
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData5?.setText(decimal.format(ans5))
        binding?.editTextData6?.setText(decimal.format(ans6))
        binding?.editTextData7?.setText(decimal.format(ans7))
        binding?.editTextData9?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun gigabitConversion(d: Double) {
        binding?.editTextData9?.setText(d.toString())
        val d2 = 1.25E8 * d
        ans1 = d2
        ans2 = 125000.0 * d
        ans3 = 125.0 * d
        ans4 = 0.125 * d
        ans5 = 1.25E-4 * d
        ans6 = 1.0E9 * d
        ans7 = 1000000.0 * d
        ans8 = 1000.0 * d
        ans9 = 0.001 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData5?.setText(decimal.format(ans5))
        binding?.editTextData6?.setText(decimal.format(ans6))
        binding?.editTextData7?.setText(decimal.format(ans7))
        binding?.editTextData8?.setText(decimal.format(ans8))
        binding?.editTextData10?.setText(decimal.format(ans9))
    }

    private fun terabitConversion(d: Double) {
        binding?.editTextData10?.setText(d.toString())
        val d2 = 1.25E11 * d
        ans1 = d2
        ans2 = 1.25E8 * d
        ans3 = 125000.0 * d
        ans4 = 125.0 * d
        ans5 = 0.125 * d
        ans6 = 1.0E12 * d
        ans7 = 1.0E9 * d
        ans8 = 1000000.0 * d
        ans9 = 1000.0 * d
        binding?.editTextData1?.setText(decimal.format(d2))
        binding?.editTextData2?.setText(decimal.format(ans2))
        binding?.editTextData3?.setText(decimal.format(ans3))
        binding?.editTextData4?.setText(decimal.format(ans4))
        binding?.editTextData5?.setText(decimal.format(ans5))
        binding?.editTextData6?.setText(decimal.format(ans6))
        binding?.editTextData7?.setText(decimal.format(ans7))
        binding?.editTextData8?.setText(decimal.format(ans8))
        binding?.editTextData9?.setText(decimal.format(ans9))
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_data1 -> {
                setUpDialog()
            }
            R.id.editText_data10 -> {
                setUpDialog()
            }
            R.id.editText_data2 -> {
                setUpDialog()
            }
            R.id.editText_data3 -> {
                setUpDialog()
            }
            R.id.editText_data4 -> {
                setUpDialog()
            }
            R.id.editText_data5 -> {
                setUpDialog()
            }
            R.id.editText_data6 -> {
                setUpDialog()
            }
            R.id.editText_data7 -> {
                setUpDialog()
            }
            R.id.editText_data8 -> {
                setUpDialog()
            }
            R.id.editText_data9 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextData1?.setText("")
                binding?.editTextData2?.setText("")
                binding?.editTextData3?.setText("")
                binding?.editTextData4?.setText("")
                binding?.editTextData5?.setText("")
                binding?.editTextData6?.setText("")
                binding?.editTextData7?.setText("")
                binding?.editTextData8?.setText("")
                binding?.editTextData9?.setText("")
                binding?.editTextData10?.setText("")
            }

            R.id.back_img -> {
                onBackPressed()
            }
        }
    }

    fun setClick() {
        binding?.editTextData1?.setOnClickListener(this)
        binding?.editTextData2?.setOnClickListener(this)
        binding?.editTextData3?.setOnClickListener(this)
        binding?.editTextData4?.setOnClickListener(this)
        binding?.editTextData5?.setOnClickListener(this)
        binding?.editTextData6?.setOnClickListener(this)
        binding?.editTextData7?.setOnClickListener(this)
        binding?.editTextData8?.setOnClickListener(this)
        binding?.editTextData9?.setOnClickListener(this)
        binding?.editTextData10?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
    }


}