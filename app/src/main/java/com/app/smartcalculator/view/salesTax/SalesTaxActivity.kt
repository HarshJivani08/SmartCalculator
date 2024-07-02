package com.app.smartcalculator.view.salesTax
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivitySalesTaxBinding
import java.text.DecimalFormat

class SalesTaxActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivitySalesTaxBinding? = null

    var ans1 = 0.0
    var ans2 = 0.0
    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesTaxBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbar?.title?.text = getString(R.string.sale_tax)
        setClick()
        spinnerList()
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressed()
            }
            R.id.calculate_c1 -> {
                calculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }
    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input price value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input tax percentage."
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            val obj: String = binding?.spinner?.selectedItem.toString()
            try {
                value1 =
                    binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                if (obj == "Add Tax") {
                    ans1 =
                        value1 / 100.0 * value2
                    ans2 =
                        value1 + ans1
                    binding?.edt3?.setText(decimalFormat.format(ans2))
                    binding?.edt4?.setText(decimalFormat.format(ans1))
                } else if (obj == "Extract Tax") {
                    ans1 =
                        value1 / 100.0 * value2
                    ans2 =
                        value1 - ans1
                    binding?.edt3?.setText(decimalFormat.format(ans2))
                    binding?.edt4?.setText(decimalFormat.format(ans1))
                }
            } catch (e: NumberFormatException) {
                val mainFinanceSales = this
                mainFinanceSales.value1 = 0.0
                mainFinanceSales.value2 = 0.0
            }
        }

    }

    private fun clearValue() {

        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt2?.setText("")
        binding?.edt1?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
    }

    private fun spinnerList() {
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, getSelection())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding?.spinner?.adapter = arrayAdapter
        binding?.spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun getSelection(): ArrayList<String> {
        val mainList = ArrayList<String>()
        mainList.add("Add Tax")
        mainList.add("Extract Tax")
        return mainList
    }

    @SuppressLint("WrongConstant")
    fun keybordopen() {
        (getSystemService("input_method") as InputMethodManager).showSoftInput(currentFocus, 1)
    }

    @SuppressLint("WrongConstant")
    fun keybordclose() {
        (getSystemService("input_method") as InputMethodManager).hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            0
        )
    }


}