package com.app.smartcalculator.view.force

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityForceBinding
import java.text.DecimalFormat

class ForceActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityForceBinding? = null

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
        binding = ActivityForceBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()

        binding?.toolbar?.title?.text = getString(R.string.force)
    }

    private fun setClick() {
        binding?.editTextForce6?.setOnClickListener(this)
        binding?.editTextForce5?.setOnClickListener(this)
        binding?.editTextForce4?.setOnClickListener(this)
        binding?.editTextForce3?.setOnClickListener(this)
        binding?.editTextForce2?.setOnClickListener(this)
        binding?.editTextForce1?.setOnClickListener(this)
        binding?.clear?.setOnClickListener(this)
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        id = p0?.id!!

        when (p0.id) {
            R.id.editText_force1 -> {
                setUpDialog()
            }
            R.id.editText_force2 -> {
                setUpDialog()
            }
            R.id.editText_force3 -> {
                setUpDialog()
            }
            R.id.editText_force4 -> {
                setUpDialog()
            }
            R.id.editText_force5 -> {
                setUpDialog()
            }
            R.id.editText_force6 -> {
                setUpDialog()
            }
            R.id.clear -> {
                binding?.editTextForce1?.setText("")
                binding?.editTextForce2?.setText("")
                binding?.editTextForce3?.setText("")
                binding?.editTextForce5?.setText("")
                binding?.editTextForce6?.setText("")
                binding?.editTextForce4?.setText("")
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
            R.id.editText_force1 -> {
                newtonConversion(d)
                return
            }
            R.id.editText_force2 -> {
                kilogramConversion(d)
                return
            }
            R.id.editText_force3 -> {
                gramConversion(d)
                return
            }
            R.id.editText_force4 -> {
                dyneConversion(d)
                return
            }
            R.id.editText_force5 -> {
                poundConversion(d)
                return
            }
            R.id.editText_force6 -> {
                ounceConversion(d)
                return
            }
            else -> return
        }
    }


    private fun ounceConversion(d: Double) {
        binding?.editTextForce6?.setText(d.toString())
        val d2 = 0.2780138500027 * d
        ans1 = d2
        ans2 = 0.02834951710694 * d
        ans3 = 28.34952302863 * d
        ans4 = 27801.38500027 * d
        ans5 = 0.06250000000035 * d
        binding?.editTextForce1?.setText(decimal.format(d2))
        binding?.editTextForce2?.setText(decimal.format(ans2))
        binding?.editTextForce3?.setText(decimal.format(ans3))
        binding?.editTextForce4?.setText(decimal.format(ans4))
        binding?.editTextForce5?.setText(decimal.format(ans5))
    }

    private fun poundConversion(d: Double) {
        binding?.editTextForce5?.setText(d.toString())
        val d2 = 4.448221600019 * d
        ans1 = d2
        ans2 = 0.4535922737085 * d
        ans3 = 453.5923684556 * d
        ans4 = 444822.1600019 * d
        ans5 = 15.99999999991 * d
        binding?.editTextForce1?.setText(decimal.format(d2))
        binding?.editTextForce2?.setText(decimal.format(ans2))
        binding?.editTextForce3?.setText(decimal.format(ans3))
        binding?.editTextForce4?.setText(decimal.format(ans4))
        binding?.editTextForce6?.setText(decimal.format(ans5))
    }

    private fun dyneConversion(d: Double) {
        binding?.editTextForce4?.setText(d.toString())
        val d2 = 1.0E-5 * d
        ans1 = d2
        ans2 = 1.019716E-6 * d
        ans3 = 0.001019716213 * d
        ans4 = 2.2480894387E-6 * d
        ans5 = 3.5969431019E-5 * d
        binding?.editTextForce1?.setText(decimal.format(d2))
        binding?.editTextForce2?.setText(decimal.format(ans2))
        binding?.editTextForce3?.setText(decimal.format(ans3))
        binding?.editTextForce5?.setText(decimal.format(ans4))
        binding?.editTextForce6?.setText(decimal.format(ans5))
    }

    private fun gramConversion(d: Double) {
        binding?.editTextForce3?.setText(d.toString())
        val d2 = 0.009806649999788 * d
        ans1 = d2
        ans2 = 9.999997911184E-4 * d
        ans3 = 980.6649999788 * d
        ans4 = 0.002204622629355 * d
        ans5 = 0.03527396206948 * d
        binding?.editTextForce1?.setText(decimal.format(d2))
        binding?.editTextForce2?.setText(decimal.format(ans2))
        binding?.editTextForce4?.setText(decimal.format(ans3))
        binding?.editTextForce5?.setText(decimal.format(ans4))
        binding?.editTextForce6?.setText(decimal.format(ans5))
    }

    private fun kilogramConversion(d: Double) {
        binding?.editTextForce2?.setText(d.toString())
        val d2 = 9.806652048217 * d
        ans1 = d2
        ans2 = 1000.000208882 * d
        ans3 = 980665.2048217 * d
        ans4 = 2.20462308986 * d
        ans5 = 35.27396943757 * d
        binding?.editTextForce1?.setText(decimal.format(d2))
        binding?.editTextForce3?.setText(decimal.format(ans2))
        binding?.editTextForce4?.setText(decimal.format(ans3))
        binding?.editTextForce5?.setText(decimal.format(ans4))
        binding?.editTextForce6?.setText(decimal.format(ans5))
    }

    private fun newtonConversion(d: Double) {
        binding?.editTextForce1?.setText(d.toString())
        ans1 = 0.1019716 * d
        ans2 = 101.9716213 * d
        ans3 = 100000.0 * d
        ans4 = 0.22480892365534 * d
        ans5 = 3.5969424550355 * d
        val editText: EditText = binding?.editTextForce2!!
        editText.setText(ans1.toString() + "")
        val editText7: EditText = binding?.editTextForce3!!
        editText7.setText(ans2.toString() + "")
        val editText8: EditText = binding?.editTextForce4!!
        editText8.setText(ans3.toString() + "")
        val editText9: EditText = binding?.editTextForce5!!
        editText9.setText(ans4.toString() + "")
        val editText10: EditText = binding?.editTextForce6!!
        editText10.setText(ans5.toString() + "")
    }




}