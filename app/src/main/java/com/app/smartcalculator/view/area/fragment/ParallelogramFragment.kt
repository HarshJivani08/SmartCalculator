package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentParallelogramBinding
import java.text.DecimalFormat

class ParallelogramFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentParallelogramBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0
    var value2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParallelogramBinding.inflate(inflater, container, false)


        binding?.parallelogram?.edt5?.visibility = View.GONE
        binding?.parallelogram?.edt4?.visibility = View.GONE
        binding?.parallelogram?.edt6?.visibility = View.GONE

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.parallelogram?.calculateC1?.setOnClickListener(this)
        binding?.parallelogram?.clearC2?.setOnClickListener(this)
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
        if (binding?.parallelogram?.edt1!!.requestFocus() || binding?.parallelogram?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.parallelogram?.edt1!!.setText("")
        binding?.parallelogram?.edt2!!.setText("")
        binding?.parallelogram?.edt3!!.setText("")
    }

    private fun caluculateValue() {

        if (binding?.parallelogram?.edt1?.text.toString().isEmpty()) {
            binding?.parallelogram?.edt1?.error = "Input parallelogram side."
            binding?.parallelogram?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.parallelogram?.edt2?.text.toString().isEmpty()) {
            binding?.parallelogram?.edt2?.error = "Input parallelogram height."
            binding?.parallelogram?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.parallelogram?.edt1?.text.toString().toDouble()
                value2 = binding?.parallelogram?.edt2?.text.toString().toDouble()
                binding?.parallelogram?.edt3?.setText(decimalFormat.format(value1 * value2))
            } catch (e: NumberFormatException) {

                val parallelogram = this@ParallelogramFragment
                parallelogram.value1 = 0.0
                parallelogram.value2 = 0.0
            }
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