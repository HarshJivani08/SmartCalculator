package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentSquareBinding
import java.text.DecimalFormat

class SquareFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentSquareBinding? = null

    var value1 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSquareBinding.inflate(inflater, container, false)

        setClick()

        binding?.square?.edt2?.visibility = View.GONE
        binding?.square?.edt5?.visibility = View.GONE
        binding?.square?.edt6?.visibility = View.GONE
        return binding!!.root

    }

    private fun setClick() {
        binding?.square?.calculateC1?.setOnClickListener(this)
        binding?.square?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.calculate_c1 -> {
                caluculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }

    }

    private fun clearValue() {
        if (binding?.square?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.square?.edt1?.setText("")
        binding?.square?.edt3?.setText("")
        binding?.square?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.square?.edt1?.text.toString().isEmpty()) {
            binding?.square?.edt1?.error = "Input square side."
            binding?.square?.edt1?.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 = binding?.square?.edt1?.text.toString().toDouble()
            binding?.square?.edt3?.setText(decimalFormat.format(value1 * value1))
            binding?.square?.edt4?.setText(decimalFormat.format(value1 * 4.0))
        } catch (e: NumberFormatException) {
            value1 = 0.0
        }
    }

    @SuppressLint("WrongConstant")
    fun keybordopen() {
        (requireActivity().getSystemService("input_method") as InputMethodManager).showSoftInput(
            requireActivity().currentFocus, 1
        )
    }

    @SuppressLint("WrongConstant")
    fun keybordclose() {
        (requireActivity().getSystemService("input_method") as InputMethodManager).hideSoftInputFromWindow(
            requireActivity().currentFocus!!.windowToken, 0
        )
    }


}