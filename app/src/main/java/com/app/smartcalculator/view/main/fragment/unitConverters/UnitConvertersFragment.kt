package com.app.smartcalculator.view.main.fragment.unitConverters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseFragment
import com.app.smartcalculator.databinding.FragmentUnitConvertersBinding
import com.app.smartcalculator.model.DataList
import com.app.smartcalculator.view.acceleration.AccelerationActivity
import com.app.smartcalculator.view.angle.AngleActivity
import com.app.smartcalculator.view.area_unit.AreaUnitActivity
import com.app.smartcalculator.view.dataTransfer.DataTransferActivity
import com.app.smartcalculator.view.energy.EnergyActivity
import com.app.smartcalculator.view.force.ForceActivity
import com.app.smartcalculator.view.main.fragment.adapter.AlgebraAdapter
import com.app.smartcalculator.view.power.PowerActivity
import com.app.smartcalculator.view.pressure.PressureActivity
import com.app.smartcalculator.view.roman.RomanActivity
import com.app.smartcalculator.view.speed.SpeedActivity
import com.app.smartcalculator.view.temperature.TemperatureActivity
import com.app.smartcalculator.view.timeUnit.TimeUnitActivity
import com.app.smartcalculator.view.torque.TorqueActivity
import com.app.smartcalculator.view.weight.WeightActivity



class UnitConvertersFragment : BaseFragment(), AlgebraAdapter.OnItemClickListeners {

    private var binding: FragmentUnitConvertersBinding? = null
    var adapter: AlgebraAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var items = arrayListOf(
        DataList(R.drawable.ic_acceleration, 0, "Acceleration", "Unit Converters"),
        DataList(R.drawable.ic_angle, 1, "Angle", "Unit Converters"),
        DataList(R.drawable.ic_areaunit, 2, "Area Unit", "Unit Converters"),
        DataList(R.drawable.ic_datatransfer, 3, "Data Transfer Speed", "Unit Converters"),
        DataList(0, 8, "", ""),
        DataList(R.drawable.ic_energy, 4, "Energy", "Unit Converters"),
        DataList(R.drawable.ic_force, 5, "Force", "Unit Converters"),
        DataList(R.drawable.ic_power, 6, "Power", "Unit Converters"),
        DataList(R.drawable.ic_pressure, 7, "Pressure", "Unit Converters"),
        DataList(0, 8, "", ""),
        DataList(R.drawable.ic_roman, 8, "Roman Numerals", "Unit Converters"),
        DataList(R.drawable.ic_speed, 9, "Speed", "Unit Converters"),
        DataList(R.drawable.ic_temperature, 10, "Temperature", "Unit Converters"),
        DataList(R.drawable.ic_timeunit, 11, "Time Unit", "Unit Converters"),
        DataList(0, 8, "", ""),
        DataList(R.drawable.ic_torque, 12, "Torque", "Unit Converters"),
        DataList(R.drawable.ic_weight, 13, "Weight", "Unit Converters"),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUnitConvertersBinding.inflate(inflater, container, false)
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
        binding?.unitRec?.layoutManager = gridLayoutManager
        adapter = AlgebraAdapter(items, this,requireActivity())
        binding?.unitRec?.adapter = adapter

    }



    override fun onItemClick(data: DataList) {
        when (data.name) {
            "Acceleration" -> {
                startActivity(Intent(context, AccelerationActivity::class.java))
            }
            "Angle" -> {
                startActivity(Intent(context, AngleActivity::class.java))
            }
            "Area Unit" -> {
                startActivity(Intent(context, AreaUnitActivity::class.java))
            }
            "Data Transfer Speed" -> {
                startActivity(Intent(context, DataTransferActivity::class.java))
            }
            "Energy" -> {
                startActivity(Intent(context, EnergyActivity::class.java))
            }
            "Force" -> {
                startActivity(Intent(context, ForceActivity::class.java))
            }
            "Power" -> {
                startActivity(Intent(context, PowerActivity::class.java))
            }
            "Pressure" -> {
                startActivity(Intent(context, PressureActivity::class.java))
            }
            "Roman Numerals" -> {
                startActivity(Intent(context, RomanActivity::class.java))
            }
            "Speed" -> {
                startActivity(Intent(context, SpeedActivity::class.java))
            }
            "Temperature" -> {
                startActivity(Intent(context, TemperatureActivity::class.java))
            }
            "Time Unit" -> {
                startActivity(Intent(context, TimeUnitActivity::class.java))
            }
            "Torque" -> {
                startActivity(Intent(context, TorqueActivity::class.java))
            }
            "Weight" -> {
                startActivity(Intent(context, WeightActivity::class.java))
            }
        }
    }



}