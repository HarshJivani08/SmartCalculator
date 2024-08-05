package com.app.smartcalculator.view.combination
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityCombinationBinding
import java.math.BigInteger

class CombinationActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityCombinationBinding? = null
    var ans = 0.0

    var f193i = 0
    var perm2 = 0.0
    var perm3 = 0.0
    var permu2 = 0.0
    var permutation1 = 0.0
    var value1 = 0.0
    var value2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombinationBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClick()
        spinnerList()

        binding?.toolbar?.title?.text = getString(R.string.combination)
    }

    private fun calculateValue() {
        if (binding?.editTextC1!!.text.toString().isEmpty()) {
            binding?.editTextC1!!.error = "Input n value."
            binding?.editTextC1!!.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextC2!!.text.toString().isEmpty()) {
            binding?.editTextC2!!.error = "Input r value."
            binding?.editTextC2!!.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            val obj: String = binding?.spinner?.selectedItem.toString()
            val obj2: String = binding?.spinner2?.selectedItem.toString()
            try {
                value1 =
                    binding?.editTextC1!!.text.toString().toDouble()
                value2 =
                    binding?.editTextC2!!.text.toString().toDouble()
                if (obj == "Yes") {
                    if (obj2 == "Yes") {
                        permutation1 =
                            Math.pow(value1, value2)
                        binding?.editTextC3!!.setText(permutation1.toString() + "")

                    }
                }
                if (obj == "Yes") {
                    if (obj2 == "No") {
                        var valueOf = BigInteger.valueOf(1)
                        f193i = 1
                        while (f193i.toDouble() <= value1) {
                            valueOf =
                                valueOf.multiply(BigInteger.valueOf(f193i.toLong()))
                            f193i++
                        }
                        permu2 = value1 - value2
                        var valueOf2 = BigInteger.valueOf(1)
                        f193i = 1
                        while (f193i.toDouble() <= permu2) {
                            valueOf2 =
                                valueOf2.multiply(BigInteger.valueOf(f193i.toLong()))
                            f193i++
                        }
                        ans = valueOf.toDouble() / valueOf2.toDouble()
                        binding?.editTextC3!!.setText(ans.toString() + "")

                    }
                }
                if (obj == "No" && obj2 == "No") {
                    var valueOf3 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= value1) {
                        valueOf3 =
                            valueOf3.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    var valueOf4 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= value2) {
                        valueOf4 =
                            valueOf4.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    permu2 = value1 - value2
                    var valueOf5 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= permu2) {
                        valueOf5 =
                            valueOf5.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    ans = valueOf3.toDouble() / (valueOf4.toDouble() * valueOf5.toDouble())
                    binding?.editTextC3!!.setText(ans.toString() + "")
                } else if (obj == "No" && obj2 == "Yes") {
                    val d: Double = value1 + value2 - 1.0
                    var valueOf6 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= d) {
                        valueOf6 =
                            valueOf6.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    var valueOf7 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= value2) {
                        valueOf7 = valueOf7.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    perm2 = value1 - 1.0
                    var valueOf8 = BigInteger.valueOf(1)
                    f193i = 1
                    while (f193i.toDouble() <= perm2) {
                        valueOf8 =
                            valueOf8.multiply(BigInteger.valueOf(f193i.toLong()))
                        f193i++
                    }
                    perm3 = valueOf7.toDouble() * valueOf8.toDouble()
                    ans = valueOf6.toDouble() / perm3
                    binding?.editTextC3!!.setText(ans.toString() + "")
                }
            } catch (e: NumberFormatException) {

                val combination: CombinationActivity = this

                combination.value1 = 0.0
                combination.value2 = 0.0
            }
        }
    }


    fun clearValue() {
        if (binding?.editTextC1!!.requestFocus() || binding?.editTextC2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextC2!!.setText("")
        binding?.editTextC1!!.setText("")
        binding?.editTextC3!!.setText("")
    }


    @SuppressLint("WrongConstant")
    fun keybordclose() {
        (getSystemService("input_method") as InputMethodManager).hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            0
        )
    }

    @SuppressLint("WrongConstant")
    fun keybordopen() {
        (getSystemService("input_method") as InputMethodManager).showSoftInput(currentFocus, 1)
    }

    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
            R.id.calculate_c1 -> {
                calculateValue()
            }
        }
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

        binding?.spinner2?.adapter = arrayAdapter
        binding?.spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        mainList.add("Yes")
        mainList.add("No")
        return mainList
    }

}