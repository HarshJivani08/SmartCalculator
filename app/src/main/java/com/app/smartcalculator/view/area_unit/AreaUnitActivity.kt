package com.app.smartcalculator.view.area_unit
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityAreaUnitBinding
import java.text.DecimalFormat

class AreaUnitActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityAreaUnitBinding? = null
    var ans1 = 0.0
    private var ans10 = 0.0
    var ans2 = 0.0
    var ans3 = 0.0
    var ans4 = 0.0
    var ans5 = 0.0
    var ans6 = 0.0
    var ans7 = 0.0
    var ans8 = 0.0
    var ans9 = 0.0
    val decimal = DecimalFormat("###.##")
    var id = 0
    var value = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAreaUnitBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.area_unit)
        setClick()

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
            R.id.editText_area1 -> {
                millimeterConversion(d)
                return
            }
            R.id.editText_area10 -> {
                arceConversion(d)
                return
            }
            R.id.editText_area11 -> {
                areConversion(d)
                return
            }
            R.id.editText_area2 -> {
                centimeterConversion(d)
                return
            }
            R.id.editText_area3 -> {
                meterConversion(d)
                return
            }
            R.id.editText_area4 -> {
                kilometerConversion(d)
                return
            }
            R.id.editText_area5 -> {
                hactareConversion(d)
                return
            }
            R.id.editText_area6 -> {
                inchConversion(d)
                return
            }
            R.id.editText_area7 -> {
                feetConversion(d)
                return
            }
            R.id.editText_area8 -> {
                yardConversion(d)
                return
            }
            R.id.editText_area9 -> {
                mileConversion(d)
                return
            }
            else -> return
        }
    }

    private fun millimeterConversion(d: Double) {
        binding?.editTextArea1?.setText(d.toString())
        val d2 = 0.01 * d
        ans1 = d2
        ans2 = 1.0E-6 * d
        ans3 = 1.0E-12 * d
        ans4 = 1.0E-10 * d
        ans5 = 0.00155 * d
        ans6 = 1.0764E-5 * d
        ans7 = 1.196E-6 * d
        ans8 = 3.861E-13 * d
        ans9 = 2.4711E-10 * d
        ans10 = 1.0E-8 * d
        binding?.editTextArea2?.setText(decimal.format(d2))
        binding?.editTextArea3?.setText(decimal.format(ans2))
        binding?.editTextArea4?.setText(decimal.format(ans3))
        binding?.editTextArea5?.setText(decimal.format(ans4))
        binding?.editTextArea6?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun centimeterConversion(d: Double) {
        binding?.editTextArea2?.setText(d.toString())
        val d2 = 100.0 * d
        ans1 = d2
        ans2 = 1.0E-4 * d
        ans3 = 1.0E-10 * d
        ans4 = 1.0E-8 * d
        ans5 = 0.155 * d
        ans6 = 0.001076 * d
        ans7 = 1.2E-4 * d
        ans8 = 3.861E-11 * d
        ans9 = 2.4711E-8 * d
        ans10 = 1.0E-6 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea3?.setText(decimal.format(ans2))
        binding?.editTextArea4?.setText(decimal.format(ans3))
        binding?.editTextArea5?.setText(decimal.format(ans4))
        binding?.editTextArea6?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun meterConversion(d: Double) {
        binding?.editTextArea3?.setText(d.toString())
        val d2 = 1000000.0 * d
        ans1 = d2
        ans2 = 10000.0 * d
        ans3 = 1.0E-6 * d
        ans4 = 1.0E-4 * d
        ans5 = 1550.0 * d
        ans6 = 10.76391 * d
        ans7 = 1.19599 * d
        ans8 = 3.861E-7 * d
        ans9 = 2.47E-4 * d
        ans10 = 0.01 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea4?.setText(decimal.format(ans3))
        binding?.editTextArea5?.setText(decimal.format(ans4))
        binding?.editTextArea6?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun kilometerConversion(d: Double) {
        binding?.editTextArea4?.setText(d.toString())
        val d2 = 1.0E12 * d
        ans1 = d2
        ans2 = 1.0E10 * d
        ans3 = 1000000.0 * d
        ans4 = 100.0 * d
        ans5 = 1.5500031E9 * d
//        ans6 = 1.076391E7 * d
        ans6 = d / 0.00000009290304
        ans7 = 1195990.0 * d
        ans8 = 0.386102 * d
        ans9 = 247.105381 * d
        ans10 = 10000.0 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea5?.setText(decimal.format(ans4))
        binding?.editTextArea6?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun hactareConversion(d: Double) {
        binding?.editTextArea5?.setText(d.toString())
        val d2 = 1.0E10 * d
        ans1 = d2
        ans2 = 1.0E8 * d
        ans3 = 10000.0 * d
        ans4 = 0.01 * d
        ans5 = 1.5500031E7 * d
        ans6 = 107639.0 * d
        ans7 = 11960.0 * d
        ans8 = 0.003861 * d
        ans9 = 2.471054 * d
        ans10 = 100.0 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea6?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun inchConversion(d: Double) {
        binding?.editTextArea6?.setText(d.toString())
        val d2 = 645.16 * d
        ans1 = d2
        ans2 = 6.4516 * d
        ans3 = 6.45E-4 * d
        ans4 = 6.4516E-10 * d
        ans5 = 6.4516E-8 * d
        ans6 = 0.006944 * d
        ans7 = 7.72E-4 * d
        ans8 = 2.491E-10 * d
        ans9 = 1.5942E-7 * d
        ans10 = 6.4516E-6 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea7?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun feetConversion(d: Double) {
        binding?.editTextArea7?.setText(d.toString())
        val d2 = 92903.0 * d
        ans1 = d2
        ans2 = 929.0304 * d
        ans3 = 0.092903 * d
        ans4 = 9.2903E-8 * d
        ans5 = 9.2903E-6 * d
        ans6 = 144.0 * d
        ans7 = 0.111111 * d
        ans8 = 2.491E-10 * d
        ans9 = 3.587E-8 * d
        ans10 = 9.29E-4 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea6?.setText(decimal.format(ans6))
        binding?.editTextArea8?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun yardConversion(d: Double) {
        binding?.editTextArea8?.setText(d.toString())
        val d2 = 836127.0 * d
        ans1 = d2
        ans2 = 8361.0 * d
        ans3 = 0.836127 * d
        ans4 = 8.3613E-7 * d
        ans5 = 8.3613E-5 * d
        ans6 = 1296.0 * d
        ans7 = 9.0 * d
        ans8 = 3.2283E-7 * d
        ans9 = 2.07E-4 * d
        ans10 = 0.008361 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea6?.setText(decimal.format(ans6))
        binding?.editTextArea7?.setText(decimal.format(ans7))
        binding?.editTextArea9?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun mileConversion(d: Double) {
        binding?.editTextArea9?.setText(d.toString())
        val d2 = 2.58998811E12 * d
        ans1 = d2
        ans2 = 2.58998811E10 * d
        ans3 = 2589988.0 * d
        ans4 = 2.589988 * d
        ans5 = 258.998811 * d
        ans6 = 4.014489599E9 * d
        ans7 = 2.78784E7 * d
        ans8 = 3097600.0 * d
        ans9 = 640.0 * d
        ans10 = 25900.0 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea6?.setText(decimal.format(ans6))
        binding?.editTextArea7?.setText(decimal.format(ans7))
        binding?.editTextArea8?.setText(decimal.format(ans8))
        binding?.editTextArea10?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun arceConversion(d: Double) {
        binding?.editTextArea10?.setText(d.toString())
        val d2 = 4.046856422E9 * d
        ans1 = d2
        ans2 = 4.0468564E7 * d
        ans3 = 4047.0 * d
        ans4 = 0.004047 * d
        ans5 = 0.404686 * d
        ans6 = 6272640.0 * d
        ans7 = 43560.0 * d
        ans8 = 4840.0 * d
        ans9 = 0.001563 * d
        ans10 = 40.468564 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea6?.setText(decimal.format(ans6))
        binding?.editTextArea7?.setText(decimal.format(ans7))
        binding?.editTextArea8?.setText(decimal.format(ans8))
        binding?.editTextArea9?.setText(decimal.format(ans9))
        binding?.editTextArea11?.setText(decimal.format(ans10))
    }

    private fun areConversion(d: Double) {
        binding?.editTextArea11?.setText(d.toString())
        val d2 = 1.0E8 * d
        ans1 = d2
        ans2 = 1000000.0 * d
        ans3 = 100.0 * d
        ans4 = 1.0E-4 * d
        ans5 = 0.01 * d
        ans6 = 155000.0 * d
        ans7 = 1076.0 * d
        ans8 = 119.599005 * d
        ans9 = 3.861E-5 * d
        ans10 = 0.024711 * d
        binding?.editTextArea1?.setText(decimal.format(d2))
        binding?.editTextArea2?.setText(decimal.format(ans2))
        binding?.editTextArea3?.setText(decimal.format(ans3))
        binding?.editTextArea4?.setText(decimal.format(ans4))
        binding?.editTextArea5?.setText(decimal.format(ans5))
        binding?.editTextArea6?.setText(decimal.format(ans6))
        binding?.editTextArea7?.setText(decimal.format(ans7))
        binding?.editTextArea8?.setText(decimal.format(ans8))
        binding?.editTextArea9?.setText(decimal.format(ans9))
        binding?.editTextArea10?.setText(decimal.format(ans10))
    }


    private fun setClick() {
        binding?.editTextArea1?.setOnClickListener(this)
        binding?.editTextArea2?.setOnClickListener(this)
        binding?.editTextArea3?.setOnClickListener(this)
        binding?.editTextArea4?.setOnClickListener(this)
        binding?.editTextArea5?.setOnClickListener(this)
        binding?.editTextArea6?.setOnClickListener(this)
        binding?.editTextArea7?.setOnClickListener(this)
        binding?.editTextArea8?.setOnClickListener(this)
        binding?.editTextArea9?.setOnClickListener(this)
        binding?.editTextArea10?.setOnClickListener(this)
        binding?.editTextArea11?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        id = p0?.id!!
        when (p0.id) {
            R.id.editText_area1 -> {
                setUpDialog()
            }
            R.id.editText_area10 -> {
                setUpDialog()
            }
            R.id.editText_area11 -> {
                setUpDialog()
            }
            R.id.editText_area2 -> {
                setUpDialog()
            }
            R.id.editText_area3 -> {
                setUpDialog()
            }
            R.id.editText_area4 -> {
                setUpDialog()
            }
            R.id.editText_area5 -> {
                setUpDialog()
            }
            R.id.editText_area6 -> {
                setUpDialog()
            }
            R.id.editText_area7 -> {
                setUpDialog()
            }
            R.id.editText_area8 -> {
                setUpDialog()
            }
            R.id.editText_area9 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextArea1?.setText("")
                binding?.editTextArea2?.setText("")
                binding?.editTextArea3?.setText("")
                binding?.editTextArea4?.setText("")
                binding?.editTextArea5?.setText("")
                binding?.editTextArea6?.setText("")
                binding?.editTextArea7?.setText("")
                binding?.editTextArea8?.setText("")
                binding?.editTextArea9?.setText("")
                binding?.editTextArea10?.setText("")
                binding?.editTextArea11?.setText("")
            }

            R.id.back_img -> {
                onBackPressed()
            }
        }
    }




}