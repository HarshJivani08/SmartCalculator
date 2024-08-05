package com.app.smartcalculator.view.pressure

import android.app.Dialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityPressureBinding
import java.text.DecimalFormat

class PressureActivity() : BaseActivity(), View.OnClickListener, Parcelable {

    private var binding: ActivityPressureBinding? = null

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

    constructor(parcel: Parcel) : this() {
        ans1 = parcel.readDouble()
        ans2 = parcel.readDouble()
        ans3 = parcel.readDouble()
        ans4 = parcel.readDouble()
        ans5 = parcel.readDouble()
        ans6 = parcel.readDouble()
        ans7 = parcel.readDouble()
        ans8 = parcel.readDouble()
        ans9 = parcel.readDouble()
        id = parcel.readInt()
        value = parcel.readDouble()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPressureBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.pressure)

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
            R.id.editText_pressure1 -> {
                atmosphereConversion(d)
                return
            }
            R.id.editText_pressure10 -> {
                torrConversion(d)
                return
            }
            R.id.editText_pressure2 -> {
                barConversion(d)
                return
            }
            R.id.editText_pressure3 -> {
                hectopascalConversion(d)
                return
            }
            R.id.editText_pressure4 -> {
                kilopascalConversion(d)
                return
            }
            R.id.editText_pressure5 -> {
                millibarConversion(d)
                return
            }
            R.id.editText_pressure6 -> {
                millimetermercuryConversion(d)
                return
            }
            R.id.editText_pressure7 -> {
                pascalConversion(d)
                return
            }
            R.id.editText_pressure8 -> {
                poundfootConversion(d)
                return
            }
            R.id.editText_pressure9 -> {
                poundinchConversion(d)
                return
            }
            else -> return
        }
    }


    private fun torrConversion(d: Double) {
        binding?.editTextPressure10?.setText(d.toString())
        val d2 = 0.001315789473684 * d
        ans1 = d2
        ans2 = 0.001333223684211 * d
        val d22 = 1.333223684211 * d
        ans3 = d22
        ans4 = 0.1333223684211 * d
        ans5 = d22
        ans6 = 1.0 * d
        ans7 = 133.3223684211 * d
        ans8 = 2.784498502865 * d
        ans9 = 0.01933679515879 * d
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure5?.setText(decimal.format(ans5))
        binding?.editTextPressure6?.setText(decimal.format(ans6))
        binding?.editTextPressure7?.setText(decimal.format(ans7))
        binding?.editTextPressure8?.setText(decimal.format(ans8))
        binding?.editTextPressure9?.setText(decimal.format(ans9))
    }

    private fun poundinchConversion(d: Double) {
        binding?.editTextPressure9?.setText(d.toString())
        val d2 = 0.0680458919319 * d
        ans1 = d2
        ans2 = 0.0689475 * d
        val d22 = 68.9475 * d
        ans3 = d22
        ans4 = 6.89475 * d
        ans5 = d22
        val d3 = 51.71487786825 * d
        ans6 = d3
        ans7 = 6894.75 * d
        ans8 = 144.0 * d
        ans9 = d3
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure5?.setText(decimal.format(ans5))
        binding?.editTextPressure6?.setText(decimal.format(ans6))
        binding?.editTextPressure7?.setText(decimal.format(ans7))
        binding?.editTextPressure8?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun poundfootConversion(d: Double) {
        binding?.editTextPressure8?.setText(d.toString())
        val d2 = 4.725409161938E-4 * d
        ans1 = d2
        ans2 = 4.788020833333E-4 * d
        val d22 = 0.4788020833333 * d
        ans3 = d22
        ans4 = 0.04788020833333 * d
        ans5 = d22
        val d3 = 0.3591310963073 * d
        ans6 = d3
        ans7 = 47.88020833333 * d
        ans8 = 0.006944444444444 * d
        ans9 = d3
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure5?.setText(decimal.format(ans5))
        binding?.editTextPressure6?.setText(decimal.format(ans6))
        binding?.editTextPressure7?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun pascalConversion(d: Double) {
        binding?.editTextPressure7?.setText(d.toString())
        val d2 = 9.86923266716E-6 * d
        ans1 = d2
        ans2 = 1.0E-5 * d
        val d22 = 0.01 * d
        ans3 = d22
        ans4 = 0.001 * d
        ans5 = d22
        val d3 = 0.007500616827042 * d
        ans6 = d3
        ans7 = 0.02088545632547 * d
        ans8 = 1.450378911491E-4 * d
        ans9 = d3
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure5?.setText(decimal.format(ans5))
        binding?.editTextPressure6?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun millimetermercuryConversion(d: Double) {
        binding?.editTextPressure6?.setText(d.toString())
        val d2 = 0.001315789473684 * d
        ans1 = d2
        ans2 = 0.001333223684211 * d
        val d22 = 1.333223684211 * d
        ans3 = d22
        ans4 = 0.1333223684211 * d
        ans5 = d22
        ans6 = 133.3223684211 * d
        ans7 = 2.784498502865 * d
        ans8 = 0.01933679515879 * d
        ans9 = 1.0 * d
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure5?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun millibarConversion(d: Double) {
        binding?.editTextPressure5?.setText(d.toString())
        val d2 = 9.86923266716E-4 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 1.0 * d
        ans4 = 0.1 * d
        val d22 = 0.7500616827042 * d
        ans5 = d22
        ans6 = 100.0 * d
        ans7 = 2.088545632547 * d
        ans8 = 0.01450378911491 * d
        ans9 = d22
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure4?.setText(decimal.format(ans4))
        binding?.editTextPressure6?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun kilopascalConversion(d: Double) {
        binding?.editTextPressure4?.setText(d.toString())
        val d2 = 0.00986923266716 * d
        ans1 = d2
        ans2 = 0.01 * d
        val d22 = 10.0 * d
        ans3 = d22
        ans4 = d22
        val d3 = 7.500616827042 * d
        ans5 = d3
        ans6 = 1000.0 * d
        ans7 = 20.88545632547 * d
        ans8 = 0.1450378911491 * d
        ans9 = d3
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure3?.setText(decimal.format(ans3))
        binding?.editTextPressure5?.setText(decimal.format(ans4))
        binding?.editTextPressure6?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun hectopascalConversion(d: Double) {
        binding?.editTextPressure3?.setText(d.toString())
        val d2 = 9.86923266716E-4 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 0.1 * d
        ans4 = 1.0 * d
        val d22 = 0.7500616827042 * d
        ans5 = d22
        ans6 = 100.0 * d
        ans7 = 2.088545632547 * d
        ans8 = 0.01450378911491 * d
        ans9 = d22
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure2?.setText(decimal.format(ans2))
        binding?.editTextPressure4?.setText(decimal.format(ans3))
        binding?.editTextPressure5?.setText(decimal.format(ans4))
        binding?.editTextPressure6?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun barConversion(d: Double) {
        binding?.editTextPressure2?.setText(d.toString())
        val d2 = 0.986923266716 * d
        ans1 = d2
        val d22 = 1000.0 * d
        ans2 = d22
        ans3 = 100.0 * d
        ans4 = d22
        val d3 = 750.0616827042 * d
        ans5 = d3
        ans6 = 100000.0 * d
        ans7 = 2088.545632547 * d
        ans8 = 14.50378911491 * d
        ans9 = d3
        binding?.editTextPressure1?.setText(decimal.format(d2))
        binding?.editTextPressure3?.setText(decimal.format(ans2))
        binding?.editTextPressure4?.setText(decimal.format(ans3))
        binding?.editTextPressure5?.setText(decimal.format(ans4))
        binding?.editTextPressure6?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    private fun atmosphereConversion(d: Double) {
        binding?.editTextPressure1?.setText(d.toString())
        val d2 = 1.01325 * d
        ans1 = d2
        val d22 = 1013.25 * d
        ans2 = d22
        ans3 = 101.325 * d
        ans4 = d22
        val d3 = 760.0 * d
        ans5 = d3
        ans6 = 101325.0 * d
        ans7 = 2116.218862178 * d
        ans8 = 14.69596432068 * d
        ans9 = d3
        binding?.editTextPressure2?.setText(decimal.format(d2))
        binding?.editTextPressure3?.setText(decimal.format(ans2))
        binding?.editTextPressure4?.setText(decimal.format(ans3))
        binding?.editTextPressure5?.setText(decimal.format(ans4))
        binding?.editTextPressure6?.setText(decimal.format(ans5))
        binding?.editTextPressure7?.setText(decimal.format(ans6))
        binding?.editTextPressure8?.setText(decimal.format(ans7))
        binding?.editTextPressure9?.setText(decimal.format(ans8))
        binding?.editTextPressure10?.setText(decimal.format(ans9))
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_pressure1 -> {
                setUpDialog()
            }
            R.id.editText_pressure10 -> {
                setUpDialog()
            }
            R.id.editText_pressure2 -> {
                setUpDialog()
            }
            R.id.editText_pressure3 -> {
                setUpDialog()
            }
            R.id.editText_pressure4 -> {
                setUpDialog()
            }
            R.id.editText_pressure5 -> {
                setUpDialog()
            }
            R.id.editText_pressure6 -> {
                setUpDialog()
            }
            R.id.editText_pressure7 -> {
                setUpDialog()
            }
            R.id.editText_pressure8 -> {
                setUpDialog()
            }
            R.id.editText_pressure9 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextPressure1?.setText("")
                binding?.editTextPressure2?.setText("")
                binding?.editTextPressure3?.setText("")
                binding?.editTextPressure4?.setText("")
                binding?.editTextPressure5?.setText("")
                binding?.editTextPressure6?.setText("")
                binding?.editTextPressure7?.setText("")
                binding?.editTextPressure8?.setText("")
                binding?.editTextPressure9?.setText("")
                binding?.editTextPressure10?.setText("")
            }

            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    fun setClick() {
        binding?.editTextPressure10?.setOnClickListener(this)
        binding?.editTextPressure1?.setOnClickListener(this)
        binding?.editTextPressure2?.setOnClickListener(this)
        binding?.editTextPressure3?.setOnClickListener(this)
        binding?.editTextPressure4?.setOnClickListener(this)
        binding?.editTextPressure5?.setOnClickListener(this)
        binding?.editTextPressure6?.setOnClickListener(this)
        binding?.editTextPressure7?.setOnClickListener(this)
        binding?.editTextPressure8?.setOnClickListener(this)
        binding?.editTextPressure9?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(ans1)
        parcel.writeDouble(ans2)
        parcel.writeDouble(ans3)
        parcel.writeDouble(ans4)
        parcel.writeDouble(ans5)
        parcel.writeDouble(ans6)
        parcel.writeDouble(ans7)
        parcel.writeDouble(ans8)
        parcel.writeDouble(ans9)
        parcel.writeInt(id)
        parcel.writeDouble(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PressureActivity> {
        override fun createFromParcel(parcel: Parcel): PressureActivity {
            return PressureActivity(parcel)
        }

        override fun newArray(size: Int): Array<PressureActivity?> {
            return arrayOfNulls(size)
        }
    }


}