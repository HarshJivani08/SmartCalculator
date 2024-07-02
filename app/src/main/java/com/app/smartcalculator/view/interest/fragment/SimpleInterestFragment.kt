
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentSimpleInterestBinding
import java.text.DecimalFormat


class SimpleInterestFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentSimpleInterestBinding? = null
    val decimalFormat = DecimalFormat("###.##")
    var value1 = 0.0
    var value2 = 0.0
    var value3 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSimpleInterestBinding.inflate(inflater, container, false)
        spinnerList()
        setClick()
        return binding!!.root
    }

    private fun setClick() {
        binding?.calculateC1?.setOnClickListener(this)
        binding?.clearC2?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.calculate_c1 -> {
                calculateValue()
            }
            R.id.clear_c2 -> {
                clearValue()
            }
        }
    }

    private fun clearValue() {
        if (binding?.edt1!!.requestFocus() || binding?.edt2!!.requestFocus() || binding?.edt3!!.requestFocus()) {
            this.keybordclose()
        }
        binding?.edt1?.setText("")
        binding?.edt2?.setText("")
        binding?.edt3?.setText("")
        binding?.edt4?.setText("")
        binding?.edt5?.setText("")
    }

    private fun calculateValue() {
        if (binding?.edt1?.text.toString().isEmpty()) {
            binding?.edt1?.error = "Input initial value."
            binding?.edt1?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt2?.text.toString().isEmpty()) {
            binding?.edt2?.error = "Input rate percentage"
            binding?.edt2?.requestFocus()
            this.keybordopen()
        } else if (binding?.edt3?.text.toString().isEmpty()) {
            binding?.edt3?.error = "Input time period."
            binding?.edt3?.requestFocus()
            this.keybordopen()
        } else {
            this.keybordclose()
            val obj: String = binding?.spinner?.selectedItem.toString()
            try {
                value1 =
                    binding?.edt1?.text.toString().toDouble()
                value2 =
                    binding?.edt2?.text.toString().toDouble()
                value3 =
                    binding?.edt3?.text.toString().toDouble()
                if (obj == "Years") {
                    val d: Double =
                        value1 * value2 * value3 / 100.0
                    binding?.edt4?.setText(decimalFormat.format(value1 + d))
                    binding?.edt5?.setText(decimalFormat.format(d))
                } else if (obj == "Months") {
                    val d2: Double =
                        value1 * value2 * value3 / 1200.0
                    binding?.edt4?.setText(decimalFormat.format(value1 + d2))
                    binding?.edt5?.setText(decimalFormat.format(d2))
                }
            } catch (e: NumberFormatException) {
                val simpleInterest = this
                simpleInterest.value1 = 0.0
                simpleInterest.value2 = 0.0
                simpleInterest.value3 = 0.0
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

    @SuppressLint("ResourceType")
    private fun spinnerList() {
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, getSelection())
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
        mainList.add("Years")
        mainList.add("Months")
        return mainList
    }

}