package com.app.smartcalculator.view.speed

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivitySpeedBinding
import java.text.DecimalFormat

class SpeedActivity : BaseActivity(), View.OnClickListener {

   private var ans1 = 0.0
   private var ans2 = 0.0
   private var ans3 = 0.0
   private var ans4 = 0.0
   private var ans5 = 0.0
   private var ans6 = 0.0
   private var ans7 = 0.0
   private val decimal = DecimalFormat("###.##")
   private var id = 0
   private var value = 0.0

    private var binding: ActivitySpeedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpeedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.speed)
    }

    private fun setClick() {
        binding?.editTextSpeed8?.setOnClickListener(this)
        binding?.editTextSpeed7?.setOnClickListener(this)
        binding?.editTextSpeed6?.setOnClickListener(this)
        binding?.editTextSpeed5?.setOnClickListener(this)
        binding?.editTextSpeed4?.setOnClickListener(this)
        binding?.editTextSpeed3?.setOnClickListener(this)
        binding?.editTextSpeed2?.setOnClickListener(this)
        binding?.editTextSpeed1?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_speed1 -> {
                setUpDialog()   }
            R.id.editText_speed2 -> {
                setUpDialog()  }
            R.id.editText_speed3 -> {
                setUpDialog() }
            R.id.editText_speed4 -> {
                setUpDialog()   }
            R.id.editText_speed5 -> {
                setUpDialog()  }
            R.id.editText_speed6 -> {
                setUpDialog()  }
            R.id.editText_speed7 -> {
                setUpDialog() }
            R.id.editText_speed8 -> {
                setUpDialog()}
            R.id.clear -> {
                binding?.editTextSpeed1?.setText("")
                binding?.editTextSpeed2?.setText("")
                binding?.editTextSpeed3?.setText("")
                binding?.editTextSpeed4?.setText("")
                binding?.editTextSpeed5?.setText("")
                binding?.editTextSpeed6?.setText("")
                binding?.editTextSpeed7?.setText("")
                binding?.editTextSpeed8?.setText("")
            }

            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
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
            R.id.editText_speed1 -> {
                kilometerhourConversion(d)
                return
            }
            R.id.editText_speed2 -> {
                metersecondConversion(d)
                return
            }
            R.id.editText_speed3 -> {
                milehourConversion(d)
                return
            }
            R.id.editText_speed4 -> {
                footsecondConversion(d)
                return
            }
            R.id.editText_speed5 -> {
                footminuteConversion(d)
                return
            }
            R.id.editText_speed6 -> {
                lightspeedConversion(d)
                return
            }
            R.id.editText_speed7 -> {
                machConversion(d)
                return
            }
            R.id.editText_speed8 -> {
                knotConversion(d)
                return
            }
            else -> return
        }
    }

    private fun knotConversion(d: Double) {
        binding?.editTextSpeed8?.setText(d.toString())
        val d2 = 1.852 * d
        ans1 = d2
        ans2 = 0.5144444444444 * d
        ans3 = 1.150779448024 * d
        val d22 = 1.687809857101 * d
        ans4 = d22
        ans5 = 60.0 * d22
        ans6 = 1.716001956408E-9 * d
        ans7 = 0.00149983803045 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed3?.setText(decimal.format(ans3))
        binding?.editTextSpeed4?.setText(decimal.format(ans4))
        binding?.editTextSpeed5?.setText(decimal.format(ans5))
        binding?.editTextSpeed6?.setText(decimal.format(ans6))
        binding?.editTextSpeed7?.setText(decimal.format(ans7))
    }

    private fun machConversion(d: Double) {
        binding?.editTextSpeed7?.setText(d.toString())
        val d2 = 1234.8 * d
        ans1 = d2
        ans2 = 343.0 * d
        ans3 = 767.2691481747 * d
        val d22 = 1125.32808399 * d
        ans4 = d22
        ans5 = 60.0 * d22
        ans6 = 1.14412484653E-6 * d
        ans7 = 666.7386609071 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed3?.setText(decimal.format(ans3))
        binding?.editTextSpeed4?.setText(decimal.format(ans4))
        binding?.editTextSpeed5?.setText(decimal.format(ans5))
        binding?.editTextSpeed6?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun lightspeedConversion(d: Double) {
        binding?.editTextSpeed6?.setText(d.toString())
        val d2 = 1.0792528488E9 * d
        ans1 = d2
        ans2 = 2.99792458E8 * d
        ans3 = 6.706166293844E8 * d
        val d22 = 9.835710564304E8 * d
        ans4 = d22
        ans5 = 60.0 * d22
        ans6 = 874030.4897959 * d
        ans7 = 5.827499183585E8 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed3?.setText(decimal.format(ans3))
        binding?.editTextSpeed4?.setText(decimal.format(ans4))
        binding?.editTextSpeed5?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun footminuteConversion(d: Double) {
        binding?.editTextSpeed5?.setText(d.toString())
        val d2 = 1.09728 * d * 60.0
        ans1 = d2
        ans2 = 0.3048 * d * 60.0
        ans3 = 0.6818181818182 * d * 60.0
        ans4 = d * 60.0 * 60.0
        ans5 = 1.016703362164E-9 * d * 60.0
        ans6 = 8.886297376093E-4 * d * 60.0
        ans7 = 0.5924838012959 * d * 60.0
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed3?.setText(decimal.format(ans3))
        binding?.editTextSpeed4?.setText(decimal.format(ans4))
        binding?.editTextSpeed6?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun footsecondConversion(d: Double) {
        binding?.editTextSpeed4?.setText(d.toString())
        val d2 = 1.09728 * d
        ans1 = d2
        ans2 = 0.3048 * d
        ans3 = 0.6818181818182 * d
        ans4 = 60.0 * d
        ans5 = 1.016703362164E-9 * d
        ans6 = 8.886297376093E-4 * d
        ans7 = 0.5924838012959 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed3?.setText(decimal.format(ans3))
        binding?.editTextSpeed5?.setText(decimal.format(ans4))
        binding?.editTextSpeed6?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun milehourConversion(d: Double) {
        binding?.editTextSpeed3?.setText(d.toString())
        val d2 = 1.609344 * d
        ans1 = d2
        ans2 = 0.44704 * d
        ans3 = 1.466666666667 * d
        ans4 = 88.00000000002 * d
        ans5 = 1.491164931174E-9 * d
        ans6 = 0.00130332361516 * d
        ans7 = 0.8689762419006 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed2?.setText(decimal.format(ans2))
        binding?.editTextSpeed4?.setText(decimal.format(ans3))
        binding?.editTextSpeed5?.setText(decimal.format(ans4))
        binding?.editTextSpeed6?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun metersecondConversion(d: Double) {
        binding?.editTextSpeed2?.setText(d.toString())
        val d2 = 3.6 * d
        ans1 = d2
        ans2 = 2.236936292054 * d
        ans3 = 3.280839895013 * d
        ans4 = 196.85039370078 * d
        ans5 = 3.335640951982E-9 * d
        ans6 = 0.002915451895044 * d
        ans7 = 1.943844492441 * d
        binding?.editTextSpeed1?.setText(decimal.format(d2))
        binding?.editTextSpeed3?.setText(decimal.format(ans2))
        binding?.editTextSpeed4?.setText(decimal.format(ans3))
        binding?.editTextSpeed5?.setText(decimal.format(ans4))
        binding?.editTextSpeed6?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

    private fun kilometerhourConversion(d: Double) {
        binding?.editTextSpeed1?.setText(d.toString())
        val d2 = 0.2777777777778 * d
        ans1 = d2
        ans2 = 0.6213711922373 * d
        ans3 = 0.9113444152814 * d
        ans4 = 54.680664916884 * d
        ans5 = 9.26566931106E-10 * d
        ans6 = 8.098477486233E-4 * d
        ans7 = 0.5399568034557 * d
        binding?.editTextSpeed2?.setText(decimal.format(d2))
        binding?.editTextSpeed3?.setText(decimal.format(ans2))
        binding?.editTextSpeed4?.setText(decimal.format(ans3))
        binding?.editTextSpeed5?.setText(decimal.format(ans4))
        binding?.editTextSpeed6?.setText(decimal.format(ans5))
        binding?.editTextSpeed7?.setText(decimal.format(ans6))
        binding?.editTextSpeed8?.setText(decimal.format(ans7))
    }

}