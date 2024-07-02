package com.app.smartcalculator.view.area.fragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentEllipseBinding
import java.text.DecimalFormat


class EllipseFragment : BaseFragment(),View.OnClickListener {
    private var binding: FragmentEllipseBinding? = null
    var value1 = 0.0
    var value2 = 0.0
    val decimalFormat = DecimalFormat("###.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEllipseBinding.inflate(inflater, container, false)
        binding?.ellipse?.initialLayout?.hint = "Radius"
        binding?.ellipse?.thirdLayout?.hint = "Angle"
        binding?.ellipse?.edt5?.visibility = View.GONE
        binding?.ellipse?.edt6?.visibility = View.GONE
        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.ellipse?.calculateC1?.setOnClickListener(this)
        binding?.ellipse?.clearC2?.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.calculate_c1 -> {
                caluculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }
    }

    private fun clearValue() {

        if (binding?.ellipse?.edt1!!.requestFocus() || binding?.ellipse?.edt2!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.ellipse?.edt1?.setText("")
        binding?.ellipse?.edt2?.setText("")
        binding?.ellipse?.edt3?.setText("")
        binding?.ellipse?.edt4?.setText("")
    }

    private fun caluculateValue() {
        if (binding?.ellipse?.edt1?.text.toString().isEmpty()) {
            binding?.ellipse?.edt1?.error = "Input ellipse radius."
            binding?.ellipse?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.ellipse?.edt2?.text.toString().isEmpty()) {
            binding?.ellipse?.edt2?.error = "Input ellipse angle."
            binding?.ellipse?.edt2?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            try {
                value1 = binding?.ellipse?.edt1?.text.toString().toDouble()
                value2 = binding?.ellipse?.edt2?.text.toString().toDouble()
                binding?.ellipse?.edt3?.setText(decimalFormat.format(value1 * 3.141592653589793 * value2))
                binding?.ellipse?.edt4?.setText(decimalFormat.format((value2 + value1) * 3.141592653589793))
            } catch (e: NumberFormatException) {
                val ellipse = this
                ellipse.value1 = 0.0
                ellipse.value2 = 0.0
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