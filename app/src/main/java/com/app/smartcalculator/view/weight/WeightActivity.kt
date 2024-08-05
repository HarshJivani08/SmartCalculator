package com.app.smartcalculator.view.weight
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityWeightBinding
import java.text.DecimalFormat

class WeightActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityWeightBinding? = null

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
        binding = ActivityWeightBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.weight)
    }

    private fun setClick() {
        binding?.editTextWeight1?.setOnClickListener(this)
        binding?.editTextWeight2?.setOnClickListener(this)
        binding?.editTextWeight3?.setOnClickListener(this)
        binding?.editTextWeight4?.setOnClickListener(this)
        binding?.editTextWeight5?.setOnClickListener(this)
        binding?.editTextWeight6?.setOnClickListener(this)
        binding?.editTextWeight7?.setOnClickListener(this)
        binding?.editTextWeight8?.setOnClickListener(this)
        binding?.editTextWeight9?.setOnClickListener(this)
        binding?.editTextWeight10?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!

        when (p0.id) {
            R.id.editText_weight1 -> {
                setUpDialog()
            }
            R.id.editText_weight2 -> {
                setUpDialog()
            }
            R.id.editText_weight3 -> {
                setUpDialog()
            }
            R.id.editText_weight4 -> {
                setUpDialog()
            }
            R.id.editText_weight5 -> {
                setUpDialog()
            }
            R.id.editText_weight6 -> {
                setUpDialog()
            }
            R.id.editText_weight7 -> {
                setUpDialog()
            }
            R.id.editText_weight8 -> {
                setUpDialog()
            }
            R.id.editText_weight9 -> {
                setUpDialog()
            }
            R.id.editText_weight10 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextWeight1?.setText("")
                binding?.editTextWeight2?.setText("")
                binding?.editTextWeight3?.setText("")
                binding?.editTextWeight4?.setText("")
                binding?.editTextWeight5?.setText("")
                binding?.editTextWeight6?.setText("")
                binding?.editTextWeight7?.setText("")
                binding?.editTextWeight8?.setText("")
                binding?.editTextWeight9?.setText("")
                binding?.editTextWeight10?.setText("")
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
        val i = id
        if (i == R.id.editText_data10) {
            longtonConversion(d)
        } else if (i != R.id.editText_weight1) {
            when (i) {
                R.id.editText_weight2 -> {
                    centimeterConversion(d)
                    return
                }
                R.id.editText_weight3 -> {
                    gramConversion(d)
                    return
                }
                R.id.editText_weight4 -> {
                    kilogramConversion(d)
                    return
                }
                R.id.editText_weight5 -> {
                    metrictonConversion(d)
                    return
                }
                R.id.editText_weight6 -> {
                    ounceConversion(d)
                    return
                }
                R.id.editText_weight7 -> {
                    poundConversion(d)
                    return
                }
                R.id.editText_weight8 -> {
                    stoneConversion(d)
                    return
                }
                R.id.editText_weight9 -> {
                    shorttonConversion(d)
                    return
                }
                else -> return
            }
        } else {
            milligramConversion(d)
        }
    }


    private fun longtonConversion(d: Double) {
        binding?.editTextWeight10?.setText(d.toString())
        val d2 = 1.0160469088E9 * d
        ans1 = d2
        ans2 = 1.0160469088E8 * d
        ans3 = 1016046.9088 * d
        ans4 = 1016.0469088 * d
        ans5 = 1.0160469088 * d
        ans6 = 35840.0 * d
        ans7 = 2240.0 * d
        ans8 = 160.0 * d
        ans9 = 1.12 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight5?.setText(decimal.format(ans5))
        binding?.editTextWeight6?.setText(decimal.format(ans6))
        binding?.editTextWeight7?.setText(decimal.format(ans7))
        binding?.editTextWeight8?.setText(decimal.format(ans8))
        binding?.editTextWeight9?.setText(decimal.format(ans9))
    }

    private fun shorttonConversion(d: Double) {
        binding?.editTextWeight9?.setText(d.toString())
        val d2 = 9.0718474E8 * d
        ans1 = d2
        ans2 = 9.0718474E7 * d
        ans3 = 907184.74 * d
        ans4 = 907.18474 * d
        ans5 = 0.90718474 * d
        ans6 = 32000.0 * d
        ans7 = 2000.0 * d
        ans8 = 142.8571428571 * d
        ans9 = 0.8928571428571 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight5?.setText(decimal.format(ans5))
        binding?.editTextWeight6?.setText(decimal.format(ans6))
        binding?.editTextWeight7?.setText(decimal.format(ans7))
        binding?.editTextWeight8?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun stoneConversion(d: Double) {
        binding?.editTextWeight8?.setText(d.toString())
        val d2 = 6350293.18 * d
        ans1 = d2
        ans2 = 635029.318 * d
        ans3 = 6350.29318 * d
        ans4 = 6.35029318 * d
        ans5 = 0.00635029 * d
        ans6 = 224.0 * d
        ans7 = 14.0 * d
        ans8 = 0.007 * d
        ans9 = 0.00625 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight5?.setText(decimal.format(ans5))
        binding?.editTextWeight6?.setText(decimal.format(ans6))
        binding?.editTextWeight7?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun poundConversion(d: Double) {
        binding?.editTextWeight7?.setText(d.toString())
        val d2 = 453592.37 * d
        ans1 = d2
        ans2 = 45359.237 * d
        ans3 = 453.59237 * d
        ans4 = 0.45359237 * d
        ans5 = 4.5359237E-4 * d
        ans6 = 16.0 * d
        ans7 = 0.07142857142857 * d
        ans8 = 5.0E-4 * d
        ans9 = 4.464285714286E-4 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight5?.setText(decimal.format(ans5))
        binding?.editTextWeight6?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun ounceConversion(d: Double) {
        binding?.editTextWeight6?.setText(d.toString())
        val d2 = 28349.523125 * d
        ans1 = d2
        ans2 = 2834.9523125 * d
        ans3 = 28.349523125 * d
        ans4 = 0.028349523125 * d
        ans5 = 2.8349523125E-5 * d
        ans6 = 0.0625 * d
        ans7 = 0.004464285714286 * d
        ans8 = 3.125E-5 * d
        ans9 = 2.790178571429E-5 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight5?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun metrictonConversion(d: Double) {
        binding?.editTextWeight5?.setText(d.toString())
        val d2 = 1.0E9 * d
        ans1 = d2
        ans2 = 1.0E8 * d
        ans3 = 1000000.0 * d
        ans4 = 1000.0 * d
        ans5 = 35274 * d
        ans6 = 2204.62 * d
        ans7 = 157.4730444178 * d
        ans8 = 1.102311310924 * d
        ans9 = 0.9842065276111 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight4?.setText(decimal.format(ans4))
        binding?.editTextWeight6?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun kilogramConversion(d: Double) {
        binding?.editTextWeight4?.setText(d.toString())
        val d2 = 1000000.0 * d
        ans1 = d2
        ans2 = 100000.0 * d
        ans3 = 1000.0 * d
        ans4 = 0.001 * d
        ans5 = 35.27396194958 * d
        ans6 = 2.204622621849 * d
        ans7 = 0.1574730444178 * d
        ans8 = 0.001102311310924 * d
        ans9 = 9.842065276111E-4 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight3?.setText(decimal.format(ans3))
        binding?.editTextWeight5?.setText(decimal.format(ans4))
        binding?.editTextWeight6?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun gramConversion(d: Double) {
        binding?.editTextWeight3?.setText(d.toString())
        val d2 = 1000.0 * d
        ans1 = d2
        ans2 = 100.0 * d
        ans3 = 0.001 * d
        ans4 = 1.0E-6 * d
        ans5 = 0.03527396194958 * d
        ans6 = 0.002204622621849 * d
        ans7 = 1.574730444178E-4 * d
        ans8 = 1.102311310924E-6 * d
        ans9 = 9.842065276111E-7 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight2?.setText(decimal.format(ans2))
        binding?.editTextWeight4?.setText(decimal.format(ans3))
        binding?.editTextWeight5?.setText(decimal.format(ans4))
        binding?.editTextWeight6?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun centimeterConversion(d: Double) {
        binding?.editTextWeight2?.setText(d.toString())
        val d2 = 10.0 * d
        ans1 = d2
        ans2 = 0.01 * d
        ans3 = 1.0E-5 * d
        ans4 = 1.0E-8 * d
        ans5 = 3.527396194958E-4 * d
        ans6 = 2.204622621849E-5 * d
        ans7 = 1.574730444178E-6 * d
        ans8 = 1.102311310924E-8 * d
        ans9 = 9.842065276111E-9 * d
        binding?.editTextWeight1?.setText(decimal.format(d2))
        binding?.editTextWeight3?.setText(decimal.format(ans2))
        binding?.editTextWeight4?.setText(decimal.format(ans3))
        binding?.editTextWeight5?.setText(decimal.format(ans4))
        binding?.editTextWeight6?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }

    private fun milligramConversion(d: Double) {
        binding?.editTextWeight1?.setText(d.toString())
        val d2 = 0.1 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 1.0E-6 * d
        ans4 = 1.0E-9 * d
        ans5 = 3.527396194958E-5 * d
        ans6 = 2.204622621849E-6 * d
        ans7 = 1.574730444178E-7 * d
        ans8 = 1.102311310924E-9 * d
        ans9 = 9.842065276111E-10 * d
        binding?.editTextWeight2?.setText(decimal.format(d2))
        binding?.editTextWeight3?.setText(decimal.format(ans2))
        binding?.editTextWeight4?.setText(decimal.format(ans3))
        binding?.editTextWeight5?.setText(decimal.format(ans4))
        binding?.editTextWeight6?.setText(decimal.format(ans5))
        binding?.editTextWeight7?.setText(decimal.format(ans6))
        binding?.editTextWeight8?.setText(decimal.format(ans7))
        binding?.editTextWeight9?.setText(decimal.format(ans8))
        binding?.editTextWeight10?.setText(decimal.format(ans9))
    }



}