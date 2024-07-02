package com.app.smartcalculator.view.main.fragment.geometry

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentGeometryBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.area.AreaActivity
import com.app.smartcalculator.view.heron.HeronActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter
import com.app.smartcalculator.view.rightTriangle.RightTriangleActivity
import com.app.smartcalculator.view.volume.VolumeActivity


class GeometryFragment : BaseFragment(), AlgebraAdapter.OnItemClickListeners {

    private var binding: FragmentGeometryBinding? = null
    var adapter: AlgebraAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var items = arrayListOf(
        DataList(R.drawable.ic_area, 0, "Area", "Geometry"),
        DataList(R.drawable.ic_volume, 1, "Volume", "Geometry"),
        DataList(R.drawable.ic_righttriangle, 2, "Right Triangle", "Geometry"),
        DataList(R.drawable.ic_herons, 3, "Heron's formula", "Geometry"),
        DataList(0,3, "", "")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeometryBinding.inflate(inflater, container, false)
        initView()

        return binding!!.root
    }




    override fun onItemClick(data: DataList) {
        when (data.name) {
            "Area" -> {
                startActivity(Intent(context, AreaActivity::class.java))
            }
            "Volume" -> {
                startActivity(Intent(context, VolumeActivity::class.java))
            }
            "Right Triangle" -> {
                startActivity(Intent(context, RightTriangleActivity::class.java))
            }
            "Heron's formula" -> {
                startActivity(Intent(context, HeronActivity::class.java))
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
        binding?.geometryRec?.layoutManager = gridLayoutManager
        adapter = AlgebraAdapter(items, this,requireActivity())
        binding?.geometryRec?.adapter = adapter

    }


}