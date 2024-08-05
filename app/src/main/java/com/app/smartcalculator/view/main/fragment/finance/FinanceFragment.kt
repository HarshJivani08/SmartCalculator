package com.app.smartcalculator.view.main.fragment.finance

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentFinanceBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.interest.InterestActivity
import com.app.smartcalculator.view.loan.LoanActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter
import com.app.smartcalculator.view.salesTax.SalesTaxActivity
import com.app.smartcalculator.view.tip.TipActivity
import com.app.smartcalculator.view.unitprice.UnitPriceActivity


class FinanceFragment : BaseFragment(), AlgebraAdapter.OnItemClickListeners {

    private var binding: FragmentFinanceBinding? = null
    var adapter: AlgebraAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var items = arrayListOf(
//        DataList(R.drawable.ic_currancy, 0, "Currency Converter", "Finance"),
        DataList(R.drawable.ic_unitprice, 1, "Unit Price", "Finance"),
        DataList(R.drawable.ic_salestax, 2, "GST", "Finance"),
        DataList(R.drawable.ic_tip, 3, "Tip", "Finance"),
        DataList(R.drawable.ic_loan, 4, "Loan", "Finance"),
        DataList(0, 4, "", ""),
        DataList(R.drawable.ic_interest, 5, "Interest", "Finance"),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFinanceBinding.inflate(inflater, container, false)

        initView()
        return binding!!.root
    }

    override fun onItemClick(data: DataList) {
//        if (data.name == "Currency Converter") {
//            startActivity(Intent(context, CurrencyConverterActivity::class.java))
//        }
        when (data.name) {
            "Unit Price" -> {
                startActivity(Intent(context, UnitPriceActivity::class.java))
            }
            "GST" -> {
                startActivity(Intent(context, SalesTaxActivity::class.java))
            }
            "Tip" -> {
                startActivity(Intent(context, TipActivity::class.java))
            }
            "Loan" -> {
                startActivity(Intent(context, LoanActivity::class.java))
            }
            "Interest" -> {
                startActivity(Intent(context, InterestActivity::class.java))
            }
        }
    }


    private fun initView() {
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (items[position].name.isEmpty()) {
                    2
                } else {
                    1
                }
            }
        }
        binding?.financeRec?.layoutManager = gridLayoutManager
        adapter = AlgebraAdapter(items, this, requireActivity())
        binding?.financeRec?.adapter = adapter
    }
}