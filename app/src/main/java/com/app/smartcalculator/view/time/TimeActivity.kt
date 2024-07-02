package com.app.smartcalculator.view.time

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivityTimeBinding
import java.util.*


class TimeActivity : BaseActivity(), View.OnClickListener {

    private var binding: ActivityTimeBinding? = null

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        spinnerList()

        binding?.toolbar?.title?.text = getString(R.string.time)
        setClick()
    }


    private fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
        binding?.editTextTd1?.setOnClickListener(this)
        binding?.editTextEnd1?.setOnClickListener(this)
        binding?.editTextEnd2?.setOnClickListener(this)
        binding?.editTextTd2?.setOnClickListener(this)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressed()
            }
            R.id.calculate_c1 -> {
                showStartTime()
            }
            R.id.clear_c2 -> {
                clearValue()
            }

        }
    }

    private fun clearValue() {


        if (binding?.editTextTd1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.editTextTd1!!.setText("")
        binding?.editTextTd2!!.setText("")
        binding?.edt5!!.setText("")
        binding?.edt4!!.setText("")
        binding?.editTextEnd1!!.setText("")
        binding?.editTextEnd2!!.setText("")
    }


    private fun showStartTime() {
        this.keybordclose()
        
        val mcurrentTime = Calendar.getInstance()
        val mcurrentTime1 = Calendar.getInstance()

        mcurrentTime.timeInMillis = 0
        mcurrentTime1.timeInMillis = 0

        val hrStrat: String = binding?.editTextTd1?.text.toString()
        val minStart: String = binding?.editTextTd2?.text.toString()
//        val spinner: Spinner? = binding?.spinner1

        val hrEnd: String = binding?.editTextEnd1?.text.toString()
        val minEnd: String = binding?.editTextEnd2?.text.toString()
//        val spinner2: Spinner? = binding?.spinner2

        mcurrentTime.set(Calendar.SECOND, 36)
//        mcurrentTime.set(Calendar.AM_PM, spinner?.id!!)
        mcurrentTime.set(Calendar.MILLISECOND, 0)

        mcurrentTime1.set(Calendar.AM_PM, 1)
//        mcurrentTime1.set(Calendar.AM_PM, spinner2?.id!!)
        mcurrentTime1.set(Calendar.MILLISECOND, 0)

//        if (hrStrat <= 24.toString() && minStart <= 24.toString() && hrEnd <= 60.toString() && minEnd <= 60.toString() && hrEnd.isNotEmpty() && hrStrat.isNotEmpty() && minEnd.isNotEmpty() && minStart.isNotEmpty()) {
//            timerCalculation()
//        } else {
//            Toast.makeText(this, "Enter valid input", Toast.LENGTH_SHORT).show()
//        }
        if (hrStrat.isEmpty()) {
            binding?.editTextTd1?.error = "Input start hr."
            binding?.editTextTd1?.requestFocus()
            this.keybordopen()
        } else if (minStart.isEmpty()) {
            binding?.editTextTd2?.error = "Input start min."
            binding?.editTextTd2?.requestFocus()
            this.keybordopen()
        } else if (hrEnd.isEmpty()) {
            binding?.editTextEnd1?.error = "Input end hr."
            binding?.editTextEnd1?.requestFocus()
            this.keybordopen()
        } else if (minEnd.isEmpty()) {
            binding?.editTextEnd2?.error = "Input end min."
            binding?.editTextEnd2?.requestFocus()
            this.keybordopen()
        } else {
            if (hrStrat.toInt() <= 24 && minStart.toInt() <= 60 && hrEnd.toInt() <= 24 && minEnd.toInt() <= 60 && hrEnd.isNotEmpty() && hrStrat.isNotEmpty() && minEnd.isNotEmpty() && minStart.isNotEmpty()) {
                timerCalculation()
            } else {
                Toast.makeText(this, "Enter valid input", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun timerCalculation() {

        val hrStrat: String = binding?.editTextTd1?.text.toString()
        val minStrat: String = binding?.editTextTd2?.text.toString()
//        val spinner: Spinner? = binding?.spinner1

        val hrEnd: String = binding?.editTextEnd1?.text.toString()
        val minEnd: String = binding?.editTextEnd2?.text.toString()
//        val spinner2: Spinner? = binding?.spinner2
        val totalHr = hrEnd.toInt() - hrStrat.toInt()
        val totalHrReverse = hrStrat.toInt() - hrEnd.toInt()
        Log.e("TAG", "timehrs123==$totalHr")

        val totalMin = minEnd.toInt() - minStrat.toInt()
        val totalMinReverse = minStrat.toInt() - minEnd.toInt()
        Log.e("TAG", "timeMin==$totalMin")

        if (hrEnd >= hrStrat) {
            binding?.edt4?.setText(totalHr.toString())
        } else {
            binding?.edt4?.setText(totalHrReverse.toString())
        }

        if (minEnd >= minStrat) {
            binding?.edt5?.setText(totalMin.toString())
        } else {
            binding?.edt5?.setText(totalMinReverse.toString())
        }
    }


    /*  private fun spinnerList() {
          val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, getSelection())
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
      }*/

    private fun getSelection(): ArrayList<String> {
        val mainList = ArrayList<String>()
        mainList.add("AM")
        mainList.add("PM")
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