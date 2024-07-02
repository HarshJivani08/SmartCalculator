package com.app.smartcalculator.view.age
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityAgeBinding

class AgeActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityAgeBinding? = null
    var value1 = 0
    var value2 = 0
    var value3 = 0
    var value4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClick()
        binding?.toolbar?.title?.text = getString(R.string.age)
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

    private fun clearValue() {

        if (binding?.editTextMa1!!.requestFocus() || binding?.editTextMa2!!.requestFocus() || binding?.editTextMa3!!.requestFocus() || binding?.editTextMa4!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextMa1?.setText("")
        binding?.editTextMa2?.setText("")
        binding?.editTextMa3?.setText("")
        binding?.editTextMa4?.setText("")
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
        binding?.edt5?.setText("")
    }


    private fun spinnerList() {
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, getSelection())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding?.spinner1?.adapter = arrayAdapter
        binding?.spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        mainList.add("January")
        mainList.add("February")
        mainList.add("March")
        mainList.add("April")
        mainList.add("May")
        mainList.add("June")
        mainList.add("July")
        mainList.add("August")
        mainList.add("September")
        mainList.add("October")
        mainList.add("November")
        mainList.add("December")
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


    private fun monthsToDays(i: Int, i2: Int): Int {
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
            return 31
        }
        return if (i == 2) {
            if (i2 % 4 == 0) 29 else 28
        } else 30
    }

    private fun gregorianDays(date: Int, month: Int, year: Int): Int {
        val i4 = (month + 9) % 12
        val i5 = date - i4 / 10
        return i5 * 365 + i5 / 4 - i5 / 100 + i5 / 400 + (i4 * 306 + 5) / 10 + (year - 1)
    }


    @SuppressLint("SetTextI18n")
    fun calculateValue() {
        val editText4: EditText
        val i: Int
        val sb4: StringBuilder
        val i2: Int
        var i3 = 0

        val birthdate : String = binding?.editTextMa1?.text.toString()
        val currentDate : String = binding?.editTextMa3?.text.toString()

        if (binding?.editTextMa1?.text.toString().isEmpty()) {
            binding?.editTextMa1?.error = "Input bday date."
            binding?.editTextMa1?.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextMa2?.text.toString().isEmpty()) {
            binding?.editTextMa2?.error = "Input bday year."
            binding?.editTextMa2?.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextMa3?.text.toString().isEmpty()) {
            binding?.editTextMa3?.error = "Input cur date."
            binding?.editTextMa3?.requestFocus()
            this.keybordopen()
        } else if (binding?.editTextMa4?.text.toString().isEmpty()) {
            binding?.editTextMa4?.error = "Input cur year."
            binding?.editTextMa4?.requestFocus()
            this.keybordopen()
        }
        else if (birthdate.toInt() > 31  || currentDate.toInt() > 31)
        {
            Toast.makeText(this, "Enter Valid Date", Toast.LENGTH_SHORT).show()
        }
        else {
            this.keybordclose()
            try {
                value1 = binding?.editTextMa1?.text.toString().toInt()
                val selectedItemPosition: Int = binding?.spinner1?.selectedItemPosition!! + 1
                value2 = binding?.editTextMa2?.text.toString().toInt()
                value3 = binding?.editTextMa3?.text.toString().toInt()
                val selectedItemPosition2: Int = binding?.spinner2?.selectedItemPosition!! + 1
                value4 = binding?.editTextMa4?.text.toString().toInt()
                val gregorianDays: Int =
                    gregorianDays(value4, selectedItemPosition2, value3) - gregorianDays(
                        value2,
                        selectedItemPosition,
                        value1
                    )
                val i32: Int = value4 - value2
                val i4 = selectedItemPosition2 - selectedItemPosition
                var i5: Int = value3 - value1
                if (i5 < 0) {
                    if (0 > 0) {
                        i3 = 0 - 1
                        i2 =
                            monthsToDays(
                                selectedItemPosition2 - 1,
                                value4
                            )
                    } else {
                        i32
                        i3 = 11
                        i2 =
                            monthsToDays(
                                selectedItemPosition2 - 1,
                                value4
                            )
                    }
                    i5 += i2
                }
//                val i6 = i32 * 12 + 4
//                val i6 = i32 * 12 + selectedItemPosition2 - 3
                val i6 = i32 * 12 + selectedItemPosition2 - 3 + 1
                if (i32 >= 0) {
                    try {
                        val i42 = i4 - selectedItemPosition + 1


                        if (i4 > 0) {
                            binding?.edt1?.setText(i32.toString() + "")
                        } else {
                            binding?.edt1?.setText((i32 - 1).toString() + "")
                        }
//                        binding?.edt1?.setText(i32.toString() + "")

                        if (i4 < 0) {
                            i32
                            val i42 = i4 + 12
                            binding?.edt2?.setText((i42 - 1).toString() + "")
                        } else if (i4 == 0) {
                            binding?.edt2?.setText(i4.toString() + "")
                        } else {
                            binding?.edt2?.setText((i4 - 1).toString() + "")
                        }
                        val i7 = selectedItemPosition
                        binding?.edt3?.setText(i5.toString() + "")
                        editText4 = binding?.edt5!!
                        i = i3
                        sb4 = StringBuilder()
                    } catch (e: NumberFormatException) {
                        val i8 = i3
                        val mainMiscellaneousAge = this
                        mainMiscellaneousAge.value1 = 0
                        mainMiscellaneousAge.value2 = 0
                        mainMiscellaneousAge.value3 = 0
                        mainMiscellaneousAge.value4 = 0
                    }
                    try {
                        val sb4: StringBuilder = java.lang.StringBuilder()
                        sb4.append(gregorianDays)
                        sb4.append("")
                        val i9 = selectedItemPosition2
                        binding?.edt5!!.setText(sb4.toString())
                        val editText = binding?.edt5!!
                        val sb = sb4

                        binding?.edt4!!.setText(i6.toString() + "")
                    } catch (e2: NumberFormatException) {
//                        val i10 = i
                        val mainMiscellaneousAge2 = this
                        mainMiscellaneousAge2.value1 = 0
                        mainMiscellaneousAge2.value2 = 0
                        mainMiscellaneousAge2.value3 = 0
                        mainMiscellaneousAge2.value4 = 0
                    }
                } else {
                    binding?.edt1!!.setText("")
                    binding?.edt2!!.setText("")
                    binding?.edt3!!.setText("")
                    binding?.edt4!!.setText("")
                    binding?.edt5!!.setText("")
                }
            } catch (e3: NumberFormatException) {
                val mainMiscellaneousAge22 = this
                mainMiscellaneousAge22.value1 = 0
                mainMiscellaneousAge22.value2 = 0
                mainMiscellaneousAge22.value3 = 0
                mainMiscellaneousAge22.value4 = 0
            }
        }
    }



}