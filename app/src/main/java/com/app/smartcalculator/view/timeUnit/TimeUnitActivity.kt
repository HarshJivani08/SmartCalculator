package com.app.smartcalculator.view.timeUnit
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityTimeUnitBinding
import java.text.DecimalFormat

class TimeUnitActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityTimeUnitBinding? = null

    private var ans1 = 0.0
    private var ans10 = 0.0
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
        binding = ActivityTimeUnitBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
    }

    private fun setClick() {
        binding?.editTextTime1?.setOnClickListener(this)
        binding?.editTextTime2?.setOnClickListener(this)
        binding?.editTextTime3?.setOnClickListener(this)
        binding?.editTextTime4?.setOnClickListener(this)
        binding?.editTextTime5?.setOnClickListener(this)
        binding?.editTextTime6?.setOnClickListener(this)
        binding?.editTextTime7?.setOnClickListener(this)
        binding?.editTextTime8?.setOnClickListener(this)
        binding?.editTextTime9?.setOnClickListener(this)
        binding?.editTextTime10?.setOnClickListener(this)
        binding?.editTextTime11?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_time1 -> {
                setUpDialog()
            }
            R.id.editText_time10 -> {
                setUpDialog()
            }
            R.id.editText_time11 -> {
                setUpDialog()
            }
            R.id.editText_time2 -> {
                setUpDialog()
            }
            R.id.editText_time3 -> {
                setUpDialog()
            }
            R.id.editText_time4 -> {
                setUpDialog()
            }
            R.id.editText_time5 -> {
                setUpDialog()
            }
            R.id.editText_time6 -> {
                setUpDialog()
            }
            R.id.editText_time7 -> {
                setUpDialog()
            }
            R.id.editText_time8 -> {
                setUpDialog()
            }
            R.id.editText_time9 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextTime1?.setText("")
                binding?.editTextTime2?.setText("")
                binding?.editTextTime3?.setText("")
                binding?.editTextTime4?.setText("")
                binding?.editTextTime5?.setText("")
                binding?.editTextTime6?.setText("")
                binding?.editTextTime7?.setText("")
                binding?.editTextTime8?.setText("")
                binding?.editTextTime9?.setText("")
                binding?.editTextTime10?.setText("")
                binding?.editTextTime11?.setText("")
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
            R.id.editText_time1 -> {
                millisecondConversion(d)
                return
            }
            R.id.editText_time10 -> {
                centuryConversion(d)
                return
            }
            R.id.editText_time11 -> {
                millenniumConversion(d)
                return
            }
            R.id.editText_time2 -> {
                secondConversion(d)
                return
            }
            R.id.editText_time3 -> {
                minuteConversion(d)
                return
            }
            R.id.editText_time4 -> {
                hourConversion(d)
                return
            }
            R.id.editText_time5 -> {
                dayConversion(d)
                return
            }
            R.id.editText_time6 -> {
                weekConversion(d)
                return
            }
            R.id.editText_time7 -> {
                monthConversion(d)
                return
            }
            R.id.editText_time8 -> {
                yearConversion(d)
                return
            }
            R.id.editText_time9 -> {
                decadeConversion(d)
                return
            }
            else -> return
        }
    }

    private fun millenniumConversion(d: Double) {
        binding?.editTextTime11?.setText(d.toString())
        val d2 = 3.1536E13 * d
        ans1 = d2
        ans2 = 3.1536E10 * d
        ans3 = 5.256E8 * d
        ans4 = 8760000.0 * d
        ans5 = 365000.0 * d
        ans6 = 52142.85714286 * d
        ans7 = 11991.68172521 * d
        ans8 = 1000.0 * d
        ans9 = 100.0 * d
        ans10 = 10.0 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime6?.setText(decimal.format(ans6))
        binding?.editTextTime7?.setText(decimal.format(ans7))
        binding?.editTextTime8?.setText(decimal.format(ans8))
        binding?.editTextTime9?.setText(decimal.format(ans9))
        binding?.editTextTime10?.setText(decimal.format(ans10))
    }

    private fun centuryConversion(d: Double) {
        binding?.editTextTime10?.setText(d.toString())
        val d2 = 3.1536E12 * d
        ans1 = d2
        ans2 = 3.1536E9 * d
        ans3 = 5.256E7 * d
        ans4 = 876000.0 * d
        ans5 = 36500.0 * d
        ans6 = 5214.285714286 * d
        ans7 = 1199.168172521 * d
        ans8 = 100.0 * d
        ans9 = 10.0 * d
        ans10 = 0.1 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime6?.setText(decimal.format(ans6))
        binding?.editTextTime7?.setText(decimal.format(ans7))
        binding?.editTextTime8?.setText(decimal.format(ans8))
        binding?.editTextTime9?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun decadeConversion(d: Double) {
        binding?.editTextTime9?.setText(d.toString())
        val d2 = 3.1536E11 * d
        ans1 = d2
        ans2 = 3.1536E8 * d
        ans3 = 5256000.0 * d
        ans4 = 87600.0 * d
        ans5 = 3650.0 * d
        ans6 = 521.4285714286 * d
        ans7 = 119.9168172521 * d
        ans8 = 10.0 * d
        ans9 = 0.1 * d
        ans10 = 0.01 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime6?.setText(decimal.format(ans6))
        binding?.editTextTime7?.setText(decimal.format(ans7))
        binding?.editTextTime8?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun yearConversion(d: Double) {
        binding?.editTextTime8?.setText(d.toString())
        val d2 = 3.1536E10 * d
        ans1 = d2
        ans2 = 3.1536E7 * d
        ans3 = 525600.0 * d
        ans4 = 8760.0 * d
        ans5 = 365.0 * d
        ans6 = 52.14285714286 * d
        ans7 = 11.99168172521 * d
        ans8 = 0.1 * d
        ans9 = 0.01 * d
        ans10 = 0.001 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime6?.setText(decimal.format(ans6))
        binding?.editTextTime7?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun monthConversion(d: Double) {
        binding?.editTextTime7?.setText(d.toString())
        val d2 = 2.62982296584E9 * d
        ans1 = d2
        ans2 = 2629822.96584 * d
        ans3 = 43830.382764 * d
        ans4 = 730.5063794 * d
        ans5 = 30.43776580833 * d
        ans6 = 4.348252258333 * d
        ans7 = 0.08339113920091 * d
        ans8 = 0.008339113920091 * d
        ans9 = 8.339113920091E-4 * d
        ans10 = 8.339113920091E-5 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime6?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun weekConversion(d: Double) {
        binding?.editTextTime6?.setText(d.toString())
        val d2 = 6.048E8 * d
        ans1 = d2
        ans2 = 604800.0 * d
        ans3 = 10080.0 * d
        ans4 = 168.0 * d
        ans5 = 7.0 * d
        ans6 = 0.2299774577438 * d
        ans7 = 0.01917808219178 * d
        ans8 = 0.001917808219178 * d
        ans9 = 1.917808219178E-4 * d
        ans10 = 1.917808219178E-5 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime5?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun dayConversion(d: Double) {
        binding?.editTextTime5?.setText(d.toString())
        val d2 = 8.64E7 * d
        ans1 = d2
        ans2 = 86400.0 * d
        ans3 = 1440.0 * d
        ans4 = 24.0 * d
        ans5 = 0.142857 * d
        ans6 = 0.032876712328767 * d
        ans7 = 0.002739726027397 * d
        ans8 = 2.739726027397E-4 * d
        ans9 = 2.739726027397E-5 * d
        ans10 = 2.739726027397E-6 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime4?.setText(decimal.format(ans4))
        binding?.editTextTime6?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun hourConversion(d: Double) {
        binding?.editTextTime4?.setText(d.toString())
        val d2 = 3600000.0 * d
        ans1 = d2
        ans2 = 3600.0 * d
        ans3 = 60.0 * d
        ans4 = 0.04166666666667 * d
        ans5 = 0.005952380952381 * d
        ans6 = 0.001368913438951 * d
        ans7 = 1.141552511416E-4 * d
        ans8 = 1.141552511416E-5 * d
        ans9 = 1.141552511416E-6 * d
        ans10 = 1.141552511416E-7 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime3?.setText(decimal.format(ans3))
        binding?.editTextTime5?.setText(decimal.format(ans4))
        binding?.editTextTime6?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun minuteConversion(d: Double) {
        binding?.editTextTime3?.setText(d.toString())
        val d2 = 60000.0 * d
        ans1 = d2
        ans2 = 60.0 * d
        ans3 = 0.01666666666667 * d
        ans4 = 6.944444444444E-4 * d
        ans5 = 9.920634920635E-5 * d
        ans6 = 2.281522398251E-5 * d
        ans7 = 1.902587519026E-6 * d
        ans8 = 1.902587519026E-7 * d
        ans9 = 1.902587519026E-8 * d
        ans10 = 1.902587519026E-9 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime2?.setText(decimal.format(ans2))
        binding?.editTextTime4?.setText(decimal.format(ans3))
        binding?.editTextTime5?.setText(decimal.format(ans4))
        binding?.editTextTime6?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun secondConversion(d: Double) {
        binding?.editTextTime2?.setText(d.toString())
        val d2 = 1000.0 * d
        ans1 = d2
        ans2 = 0.01666666666667 * d
        ans3 = 2.777777777778E-4 * d
        ans4 = 1.157407407407E-5 * d
        ans5 = 1.653439153439E-6 * d
        ans6 = 3.802537330419E-7 * d
        ans7 = 3.170979198377E-8 * d
        ans8 = 3.170979198377E-9 * d
        ans9 = 3.170979198377E-10 * d
        ans10 = 3.170979198377E-11 * d
        binding?.editTextTime1?.setText(decimal.format(d2))
        binding?.editTextTime3?.setText(decimal.format(ans2))
        binding?.editTextTime4?.setText(decimal.format(ans3))
        binding?.editTextTime5?.setText(decimal.format(ans4))
        binding?.editTextTime6?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }

    private fun millisecondConversion(d: Double) {
        binding?.editTextTime1?.setText(d.toString())
        val d2 = 0.001 * d
        ans1 = d2
        ans2 = 1.666666666667E-5 * d
        ans3 = 2.777777777778E-7 * d
        ans4 = 1.157407407407E-8 * d
        ans5 = 1.653439153439E-9 * d
        ans6 = 3.802537330419E-10 * d
        ans7 = 3.170979198377E-11 * d
        ans8 = 3.170979198377E-12 * d
        ans9 = 3.170979198377E-13 * d
        ans10 = 3.170979198377E-14 * d
        binding?.editTextTime2?.setText(decimal.format(d2))
        binding?.editTextTime3?.setText(decimal.format(ans2))
        binding?.editTextTime4?.setText(decimal.format(ans3))
        binding?.editTextTime5?.setText(decimal.format(ans4))
        binding?.editTextTime6?.setText(decimal.format(ans5))
        binding?.editTextTime7?.setText(decimal.format(ans6))
        binding?.editTextTime8?.setText(decimal.format(ans7))
        binding?.editTextTime9?.setText(decimal.format(ans8))
        binding?.editTextTime10?.setText(decimal.format(ans9))
        binding?.editTextTime11?.setText(decimal.format(ans10))
    }




}