package com.app.smartcalculator.view.main.fragment.algebra
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentAlgebraBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.averageMean.AverageMeanActivity
import com.app.smartcalculator.view.combination.CombinationActivity
import com.app.smartcalculator.view.decimaltofraction.DecimaltoFractionActivity
import com.app.smartcalculator.view.equationsolver.EquationSolverActivity
import com.app.smartcalculator.view.fractionSimplifire.FractionSimplifireActivity
import com.app.smartcalculator.view.gcf_lcm.GcfLcmActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter
import com.app.smartcalculator.view.percentage.PercentageActivity
import com.app.smartcalculator.view.proportion.ProportionActivity



class AlgebraFragment : BaseFragment(), AlgebraAdapter.OnItemClickListeners {

    private var items = arrayListOf(
        DataList(R.drawable.ic_percentage__, 0, "Percentage", "Algebra"),
        DataList(R.drawable.ic_average_mean, 1, "Average/Mean", "Algebra"),
        DataList(R.drawable.ic_proportion_ratio, 2, "Proportion/Ratio", "Algebra"),
        DataList(R.drawable.ic_equation, 3, "Equation Solver", "Algebra"),
        DataList(0, 8, "", ""),
        DataList(R.drawable.ic_combination, 4, "Combinations", "Algebra"),
        DataList(R.drawable.decimal_fraction, 5, "Decimal to Fraction", "Algebra"),
        DataList(R.drawable.ic_fraction, 6, "Fraction simplifier", "Algebra"),
        DataList(R.drawable.ic_gcf_lcm, 7, "GCF/LCM", "Algebra"),
    )

    private var binding: FragmentAlgebraBinding? = null
    var adapter: AlgebraAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentAlgebraBinding.inflate(inflater, container, false)
        initView()
        return binding!!.root
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
        binding?.algebraRec?.layoutManager = gridLayoutManager
        adapter = AlgebraAdapter(items, this,requireActivity())
        binding?.algebraRec?.adapter = adapter

    }


    override fun onItemClick(data: DataList) {
        when (data.name) {
            "Percentage" -> {
                startActivity(Intent(context, PercentageActivity::class.java))
            }
            "Average/Mean" -> {
                startActivity(Intent(context, AverageMeanActivity::class.java))
            }
            "Proportion/Ratio" -> {
                startActivity(Intent(context, ProportionActivity::class.java))
            }
            "Equation Solver" -> {
                startActivity(Intent(context, EquationSolverActivity::class.java))
            }
            "Combinations" -> {
                startActivity(Intent(context, CombinationActivity::class.java))
            }
            "Decimal to Fraction" -> {
                startActivity(Intent(context, DecimaltoFractionActivity::class.java))
            }
            "Fraction simplifier" -> {
                startActivity(Intent(context, FractionSimplifireActivity::class.java))
            }
            "GCF/LCM" -> {
                startActivity(Intent(context, GcfLcmActivity::class.java))
            }

        }

    }

}