package com.app.smartcalculator.view.energy
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityEnergyBinding
import java.math.BigInteger
import java.text.DecimalFormat

class EnergyActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityEnergyBinding? = null

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
        binding = ActivityEnergyBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.energy)
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

    private fun convertMethod(d: Double) {
        when (id) {
            R.id.editText_energy1 -> {
                megajouleConversion(d)
                return
            }
            R.id.editText_energy10 -> {
                wattConversion(d)
                return
            }
            R.id.editText_energy11 -> {
                btuConversion(d)
                return
            }
            R.id.editText_energy2 -> {
                kilojouleConversion(d)
                return
            }
            R.id.editText_energy3 -> {
                jouleConversion(d)
                return
            }
            R.id.editText_energy4 -> {
                ergConversion(d)
                return
            }
            R.id.editText_energy5 -> {
                electronvoltConversion(d)
                return
            }
            R.id.editText_energy6 -> {
                kilocalorieConversion(d)
                return
            }
            R.id.editText_energy7 -> {
                calorieConversion(d)
                return
            }
            R.id.editText_energy8 -> {
                foodConversion(d)
                return
            }
            R.id.editText_energy9 -> {
                kilowattConversion(d)
                return
            }
            else -> return
        }
    }

    private fun megajouleConversion(d: Double) {
        binding?.editTextEnergy1?.setText(d.toString())
        val d2 = 1000.0 * d
        ans1 = d2
        ans2 = 1000000.0 * d
        ans3 = 1.0E13 * d
        ans4 = 6.241509744512E24 * d
        ans5 = 238.8458966275 * d
        ans6 = 238845.8966275 * d
        ans7 = 737562.1492773 * d
        ans8 = 0.2777777777778 * d
        ans9 = 277.7777777778 * d
        ans10 = 947.8169879134 * d
        binding?.editTextEnergy2?.setText(decimal.format(d2))
        binding?.editTextEnergy3?.setText(decimal.format(ans2))
        binding?.editTextEnergy4?.setText(decimal.format(ans3))
        binding?.editTextEnergy5?.setText(decimal.format(ans4))
        binding?.editTextEnergy6?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun kilojouleConversion(d: Double) {
        binding?.editTextEnergy2?.setText(d.toString())
        val d2 = 0.001 * d
        ans1 = d2
        ans2 = 1000.0 * d
        ans3 = 1.0E10 * d
        ans4 = 6.241509744512E21 * d
        ans5 = 0.2388458966275 * d
        ans6 = 238.8458966275 * d
        ans7 = 737.5621492773 * d
        ans8 = 2.777777777778E-4 * d
        ans9 = 0.2777777777778 * d
        ans10 = 0.9478169879134 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy3?.setText(decimal.format(ans2))
        binding?.editTextEnergy4?.setText(decimal.format(ans3))
        binding?.editTextEnergy5?.setText(decimal.format(ans4))
        binding?.editTextEnergy6?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun jouleConversion(d: Double) {
        binding?.editTextEnergy3?.setText(d.toString())
        val d2 = 1.0E-6 * d
        ans1 = d2
        ans2 = 0.001 * d
        ans3 = 1.0E7 * d
        ans4 = 6.241509744512E18 * d
        ans5 = 2.388458966275E-4 * d
        ans6 = 0.2388458966275 * d
        ans7 = 0.7375621492773 * d
        ans8 = 2.777777777778E-7 * d
        ans9 = 2.777777777778E-4 * d
        ans10 = 9.478169879134E-4 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy4?.setText(decimal.format(ans3))
        binding?.editTextEnergy5?.setText(decimal.format(ans4))
        binding?.editTextEnergy6?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun ergConversion(d: Double) {
        binding?.editTextEnergy4?.setText(d.toString())
        val d2 = 1.0E-13 * d
        ans1 = d2
        ans2 = 1.0E-10 * d
        ans3 = 1.0E-7 * d
        ans4 = 6.241509744512E11 * d
        ans5 = 2.388458966275E-11 * d
        ans6 = 2.388458966275E-8 * d
        ans7 = 7.375621492773E-8 * d
        ans8 = 2.777777777778E-14 * d
        ans9 = 2.777777777778E-11 * d
        ans10 = 9.478169879134E-11 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy5?.setText(decimal.format(ans4))
        binding?.editTextEnergy6?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun electronvoltConversion(d: Double) {
        binding?.editTextEnergy5?.setText(d.toString())
        val d2 = 1.602176462E-25 * d
        ans1 = d2
        ans2 = 1.602176462E-22 * d
        ans3 = 1.602176462E-19 * d
        ans4 = 1.602176462E-12 * d
        ans5 = 3.826732736219E-23 * d
        ans6 = 3.826732736219E-20 * d
        ans7 = 1.181704714834E-19 * d
        ans8 = 4.450490172222E-26 * d
        ans9 = 4.450490172222E-23 * d
        ans10 = 1.518570068319E-22 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy6?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun kilocalorieConversion(d: Double) {
        binding?.editTextEnergy1?.setText(d.toString())
        val d2 = 0.0041868 * d
        ans1 = d2
        ans2 = 4.1868 * d
        ans3 = 4186.8 * d
        ans4 = 4.1868E10 * d
        ans5 = 2.613195299832E22 * d
        ans6 = 1000.0 * d
        ans7 = 3088.025206594 * d
        ans8 = 0.001163 * d
        ans9 = 1.163 * d
        ans10 = 3.968320164996 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy7?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun calorieConversion(d: Double) {
        binding?.editTextEnergy7?.setText(d.toString())
        ans1 = 4.1868E-6 * d
        ans2 = 0.0041868 * d
        ans3 = 4.1868 * d
        ans4 = 4.1868E7 * d
        ans5 = BigInteger("26131952998320000000").toString().toDouble() * d
        ans6 = 0.001 * d
        ans7 = 3.088025206594 * d
        ans8 = 1.163E-6 * d
        ans9 = 0.001163 * d
        ans10 = 0.003968320164996 * d
        binding?.editTextEnergy1?.setText(decimal.format(ans1))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy6?.setText(decimal.format(ans6))
        binding?.editTextEnergy8?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun foodConversion(d: Double) {
        binding?.editTextEnergy8?.setText(d.toString())
        ans1 = 1.355817948331E-6 * d
        ans2 = 0.001355817948331 * d
        ans3 = 1.355817948331 * d
        ans4 = 1.355817948331E7 * d
        ans5 = BigInteger(" 8462350936294000000").toString().toDouble() * d
        ans6 = 3.238315535329E-4 * d
        ans7 = 0.3238315535329 * d
        ans8 = 3.766160967587E-7 * d
        ans9 = 3.766160967587E-4 * d
        ans10 = 0.001285067283946 * d
        binding?.editTextEnergy1?.setText(decimal.format(ans1))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy6?.setText(decimal.format(ans6))
        binding?.editTextEnergy7?.setText(decimal.format(ans7))
        binding?.editTextEnergy9?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun kilowattConversion(d: Double) {
        binding?.editTextEnergy9?.setText(d.toString())
        val d2 = 3.6 * d
        ans1 = d2
        ans2 = 3600.0 * d
        ans3 = 3600000.0 * d
        ans4 = 3.6E13 * d
        ans5 = 2.246943508024E25 * d
        ans6 = 859.845227859 * d
        ans7 = 859845.227859 * d
        ans8 = 2655223.737398 * d
        ans9 = 1000.0 * d
        ans10 = 3412.141156488 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy6?.setText(decimal.format(ans6))
        binding?.editTextEnergy7?.setText(decimal.format(ans7))
        binding?.editTextEnergy8?.setText(decimal.format(ans8))
        binding?.editTextEnergy10?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun wattConversion(d: Double) {
        binding?.editTextEnergy10?.setText(d.toString())
        val d2 = 0.0036 * d
        ans1 = d2
        ans2 = 3.6 * d
        ans3 = 3600.0 * d
        ans4 = 3.6E10 * d
        ans5 = 2.246943508024E22 * d
        ans6 = 0.859845227859 * d
        ans7 = 859.845227859 * d
        ans8 = 2655.223737398 * d
        ans9 = 0.001 * d
        ans10 = 3.412141156488 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy6?.setText(decimal.format(ans6))
        binding?.editTextEnergy7?.setText(decimal.format(ans7))
        binding?.editTextEnergy8?.setText(decimal.format(ans8))
        binding?.editTextEnergy9?.setText(decimal.format(ans9))
        binding?.editTextEnergy11?.setText(decimal.format(ans10))
    }

    private fun btuConversion(d: Double) {
        binding?.editTextEnergy11?.setText(d.toString())
        val d2 = 0.001055056 * d
        ans1 = d2
        ans2 = 1.055056 * d
        ans3 = 1055.056 * d
//        ans4 = 1.055056E10 * d
        ans4 = 10550559000 * d
        ans5 = 6.585142305005E21 * d
        ans6 = 0.2519957963122 * d
        ans7 = 251.995796312 * d
        ans8 = 778.1693709679 * d
        ans9 = 2.930711111111E-4 * d
        ans10 = 0.2930711111111 * d
        binding?.editTextEnergy1?.setText(decimal.format(d2))
        binding?.editTextEnergy2?.setText(decimal.format(ans2))
        binding?.editTextEnergy3?.setText(decimal.format(ans3))
        binding?.editTextEnergy4?.setText(decimal.format(ans4))
        binding?.editTextEnergy5?.setText(decimal.format(ans5))
        binding?.editTextEnergy6?.setText(decimal.format(ans6))
        binding?.editTextEnergy7?.setText(decimal.format(ans7))
        binding?.editTextEnergy8?.setText(decimal.format(ans8))
        binding?.editTextEnergy9?.setText(decimal.format(ans9))
        binding?.editTextEnergy10?.setText(decimal.format(ans10))
    }

    override fun onClick(p0: View?) {
        id = p0?.id!!
        when (p0.id) {
            R.id.editText_energy1 -> {
                setUpDialog()
            }
            R.id.editText_energy10 -> {
                setUpDialog()
            }
            R.id.editText_energy11 -> {
                setUpDialog()
            }
            R.id.editText_energy2 -> {
                setUpDialog()
            }
            R.id.editText_energy3 -> {
                setUpDialog()
            }
            R.id.editText_energy4 -> {
                setUpDialog()
            }
            R.id.editText_energy5 -> {
                setUpDialog()
            }
            R.id.editText_energy6 -> {
                setUpDialog()
            }
            R.id.editText_energy7 -> {
                setUpDialog()
            }
            R.id.editText_energy8 -> {
                setUpDialog()
            }
            R.id.editText_energy9 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextEnergy1?.setText("")
                binding?.editTextEnergy2?.setText("")
                binding?.editTextEnergy3?.setText("")
                binding?.editTextEnergy4?.setText("")
                binding?.editTextEnergy5?.setText("")
                binding?.editTextEnergy6?.setText("")
                binding?.editTextEnergy7?.setText("")
                binding?.editTextEnergy8?.setText("")
                binding?.editTextEnergy9?.setText("")
                binding?.editTextEnergy10?.setText("")
                binding?.editTextEnergy11?.setText("")
            }

            R.id.back_img -> {
                onBackPressed()
            }
        }
    }

    fun setClick() {
        binding?.editTextEnergy1?.setOnClickListener(this)
        binding?.editTextEnergy2?.setOnClickListener(this)
        binding?.editTextEnergy3?.setOnClickListener(this)
        binding?.editTextEnergy4?.setOnClickListener(this)
        binding?.editTextEnergy5?.setOnClickListener(this)
        binding?.editTextEnergy6?.setOnClickListener(this)
        binding?.editTextEnergy7?.setOnClickListener(this)
        binding?.editTextEnergy8?.setOnClickListener(this)
        binding?.editTextEnergy9?.setOnClickListener(this)
        binding?.editTextEnergy10?.setOnClickListener(this)
        binding?.editTextEnergy11?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }



}