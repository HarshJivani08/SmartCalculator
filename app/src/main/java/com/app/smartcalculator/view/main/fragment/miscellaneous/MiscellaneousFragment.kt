package com.app.smartcalculator.view.main.fragment.miscellaneous

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentMiscellaneousBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.age.AgeActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter
import com.app.smartcalculator.view.mileage.MileageActivity
import com.app.smartcalculator.view.ohm.OhmLawActivity
import com.app.smartcalculator.view.time.TimeActivity

class MiscellaneousFragment : BaseFragment(), AlgebraAdapter.OnItemClickListeners {

    private var binding: FragmentMiscellaneousBinding? = null

    private var items = arrayListOf(
        DataList(R.drawable.ic_age, 0, "Age", "Miscellaneous"),
        DataList(R.drawable.ic_time, 1, "Time", "Miscellaneous"),
        DataList(R.drawable.ic_mileage, 2, "Mileage", "Miscellaneous"),
        DataList(R.drawable.ic_ohmlow, 3, "Ohm's Low", "Miscellaneous")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMiscellaneousBinding.inflate(inflater, container, false)

        initAdapter()
        return binding!!.root
    }

    private fun initAdapter() {
        binding?.miscellaneousRec?.apply {
            binding?.miscellaneousRec?.layoutManager = GridLayoutManager(context, 2)
            val adapter = AlgebraAdapter(items, this@MiscellaneousFragment, requireActivity())
            binding?.miscellaneousRec?.adapter = adapter
        }
    }



    override fun onItemClick(data: DataList) {
        when (data.name) {
            "Age" -> {
                startActivity(Intent(context, AgeActivity::class.java))
            }
            "Time" -> {
                startActivity(Intent(context, TimeActivity::class.java))
            }
            "Mileage" -> {
                startActivity(Intent(context, MileageActivity::class.java))
            }
            "Ohm's Low" -> {
                startActivity(Intent(context, OhmLawActivity::class.java))
            }
        }
    }

}