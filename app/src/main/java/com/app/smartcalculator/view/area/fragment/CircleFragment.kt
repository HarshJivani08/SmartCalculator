package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentCircleBinding
import java.text.DecimalFormat

class CircleFragment : BaseFragment(),View.OnClickListener{
    private var binding: FragmentCircleBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCircleBinding.inflate(inflater, container, false)

        binding?.circle?.edt5?.visibility = View.GONE
        binding?.circle?.edt2?.visibility = View.GONE
        binding?.circle?.edt6?.visibility = View.GONE
        binding?.circle?.initialLayout?.hint = "Radius"

        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.circle?.calculateC1?.setOnClickListener(this)
        binding?.circle?.clearC2?.setOnClickListener(this)
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

        if (binding?.circle?.edt1!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.circle?.edt1?.setText("")
        binding?.circle?.edt3?.setText("")
        binding?.circle?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.circle?.edt1!!.getText().toString().isEmpty()) {
            binding?.circle?.edt1!!.setError("Input pentagon side.")
            binding?.circle?.edt1!!.requestFocus()
            this.keybordopen()
            return
        }
        this.keybordclose()
        try {
            value1 = binding?.circle?.edt1!!.getText().toString().toDouble()
            binding?.circle?.edt3!!.setText(decimalFormat.format(value1 * 3.141592653589793 * value1))
            binding?.circle?.edt4!!.setText(decimalFormat.format(value1 * 6.283185307179586))
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