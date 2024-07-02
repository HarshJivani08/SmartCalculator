package com.app.smartcalculator.view.main.fragment.health

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentHealthBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.bodyFatPercentage.BodyFatPercentageActivity
import com.app.smartcalculator.view.bodymass.BodyMassActivity
import com.app.smartcalculator.view.dailyCaloricBurn.DailyCaloricBurnActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter


class HealthFragment : BaseFragment() , AlgebraAdapter.OnItemClickListeners {

    private var binding: FragmentHealthBinding? = null

    private var items = arrayListOf(
        DataList(R.drawable.ic_bodymass, 0, "Body Mass Index", "Health"),
        DataList(R.drawable.ic_dailycaloric, 1, "Daily Caloric Burn", "Health"),
        DataList(R.drawable.ic_bodyfat, 2, "Body Fat Percentage", "Health")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthBinding.inflate(inflater, container, false)

        initAdapter()

        return binding!!.root

    }

    override fun onItemClick(data: DataList) {
        when (data.name) {
            "Body Mass Index" -> {
                startActivity(Intent(context, BodyMassActivity::class.java))
            }
            "Daily Caloric Burn" -> {
                startActivity(Intent(context, DailyCaloricBurnActivity::class.java))
            }
            "Body Fat Percentage" -> {
                startActivity(Intent(context, BodyFatPercentageActivity::class.java))
            }
        }

    }

    private fun initAdapter() {
        binding?.healthRec?.apply {
            binding?.healthRec?.layoutManager = GridLayoutManager(context, 2)
            val adapter = AlgebraAdapter(items, this@HealthFragment, requireActivity())
            binding?.healthRec?.adapter = adapter
        }
    }


}