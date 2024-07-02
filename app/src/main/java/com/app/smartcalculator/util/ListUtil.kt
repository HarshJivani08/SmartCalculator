package com.app.smartcalculator.util
import android.content.Intent
import com.app.smartcalculator.R
import com.app.smartcalculator.app.SmartCalcApp
import com.app.smartcalculator.model.SearchItem
import com.app.smartcalculator.view.acceleration.AccelerationActivity
import com.app.smartcalculator.view.age.AgeActivity
import com.app.smartcalculator.view.angle.AngleActivity
import com.app.smartcalculator.view.area.AreaActivity
import com.app.smartcalculator.view.area_unit.AreaUnitActivity
import com.app.smartcalculator.view.averageMean.AverageMeanActivity
import com.app.smartcalculator.view.bodyFatPercentage.BodyFatPercentageActivity
import com.app.smartcalculator.view.bodymass.BodyMassActivity
import com.app.smartcalculator.view.combination.CombinationActivity
import com.app.smartcalculator.view.dailyCaloricBurn.DailyCaloricBurnActivity
import com.app.smartcalculator.view.dataTransfer.DataTransferActivity
import com.app.smartcalculator.view.decimaltofraction.DecimaltoFractionActivity
import com.app.smartcalculator.view.energy.EnergyActivity
import com.app.smartcalculator.view.equationsolver.EquationSolverActivity
import com.app.smartcalculator.view.force.ForceActivity
import com.app.smartcalculator.view.fractionSimplifire.FractionSimplifireActivity
import com.app.smartcalculator.view.gcf_lcm.GcfLcmActivity
import com.app.smartcalculator.view.heron.HeronActivity
import com.app.smartcalculator.view.interest.InterestActivity
import com.app.smartcalculator.view.loan.LoanActivity
import com.app.smartcalculator.view.mileage.MileageActivity
import com.app.smartcalculator.view.ohm.OhmLawActivity
import com.app.smartcalculator.view.percentage.PercentageActivity
import com.app.smartcalculator.view.power.PowerActivity
import com.app.smartcalculator.view.pressure.PressureActivity
import com.app.smartcalculator.view.proportion.ProportionActivity
import com.app.smartcalculator.view.rightTriangle.RightTriangleActivity
import com.app.smartcalculator.view.roman.RomanActivity
import com.app.smartcalculator.view.salesTax.SalesTaxActivity
import com.app.smartcalculator.view.speed.SpeedActivity
import com.app.smartcalculator.view.temperature.TemperatureActivity
import com.app.smartcalculator.view.time.TimeActivity
import com.app.smartcalculator.view.timeUnit.TimeUnitActivity
import com.app.smartcalculator.view.tip.TipActivity
import com.app.smartcalculator.view.torque.TorqueActivity
import com.app.smartcalculator.view.unitprice.UnitPriceActivity
import com.app.smartcalculator.view.volume.VolumeActivity
import com.app.smartcalculator.view.weight.WeightActivity


class ListUtil {
    companion object {
        fun getAlgebraList(): ArrayList<SearchItem> {
            val itemList: ArrayList<SearchItem> = ArrayList()

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_percentage__,
                    title = "Percentage",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        PercentageActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_average_mean,
                    title = "Average/Mean",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        AverageMeanActivity::class.java
                    )
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_proportion_ratio,
                    title = "Proportion/Ratio",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        ProportionActivity::class.java
                    )
                )
            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_equation,
                    title = "Equation Solver",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        EquationSolverActivity::class.java
                    )
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_combination,
                    title = "Combinations",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        CombinationActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.decimal_fraction,
                    title = "Decimal to Fraction",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        DecimaltoFractionActivity::class.java
                    )
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )



            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_fraction,
                    title = "Fraction simplifier",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        FractionSimplifireActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_gcf_lcm,
                    title = "GCF/LCM",
                    intent = Intent(SmartCalcApp.getAppInstance(), GcfLcmActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_area,
                    title = "Area",
                    intent = Intent(SmartCalcApp.getAppInstance(), AreaActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_volume,
                    title = "Volume",
                    intent = Intent(SmartCalcApp.getAppInstance(), VolumeActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_righttriangle,
                    title = "Right Triangle",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        RightTriangleActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_herons,
                    title = "Heron's formula",
                        intent = Intent(SmartCalcApp.getAppInstance(), HeronActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_acceleration,
                    title = "Acceleration",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        AccelerationActivity::class.java
                    )
                )
            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_angle,
                    title = "Angle",
                    intent = Intent(SmartCalcApp.getAppInstance(), AngleActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_areaunit,
                    title = "Area Unit",
                    intent = Intent(SmartCalcApp.getAppInstance(), AreaUnitActivity::class.java)
                )
            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_datatransfer,
                    title = "Data Transfer Speed",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        DataTransferActivity::class.java
                    )
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )



            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_energy,
                    title = "Energy",
                    intent = Intent(SmartCalcApp.getAppInstance(), EnergyActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_force,
                    title = "Force",
                    intent = Intent(SmartCalcApp.getAppInstance(), ForceActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_power,
                    title = "Power",
                    intent = Intent(SmartCalcApp.getAppInstance(), PowerActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_pressure,
                    title = "Pressure",
                    intent = Intent(SmartCalcApp.getAppInstance(), PressureActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_roman,
                    title = "Roman Numerals",
                    intent = Intent(SmartCalcApp.getAppInstance(), RomanActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_speed,
                    title = "Speed",
                    intent = Intent(SmartCalcApp.getAppInstance(), SpeedActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_temperature,
                    title = "Temperature",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        TemperatureActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_timeunit,
                    title = "Time Unit",
                    intent = Intent(SmartCalcApp.getAppInstance(), TimeUnitActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_torque,
                    title = "Torque",
                    intent = Intent(SmartCalcApp.getAppInstance(), TorqueActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_weight,
                    title = "Weight",
                    intent = Intent(SmartCalcApp.getAppInstance(), WeightActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_unitprice,
                    title = "Unit Price",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        UnitPriceActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_salestax,
                    title = "Sales Tax",
                    intent = Intent(SmartCalcApp.getAppInstance(), SalesTaxActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_tip,
                    title = "Tip",
                    intent = Intent(SmartCalcApp.getAppInstance(), TipActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_loan,
                    title = "Loan",
                    intent = Intent(SmartCalcApp.getAppInstance(), LoanActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_interest,
                    title = "Interest",
                    intent = Intent(SmartCalcApp.getAppInstance(), InterestActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_bodymass,
                    title = "Body Mass Index",
                    intent = Intent(SmartCalcApp.getAppInstance(), BodyMassActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_dailycaloric,
                    title = "Daily Caloric Burn",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        DailyCaloricBurnActivity::class.java
                    )
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_bodyfat,
                    title = "Body Fat Percentage",
                    intent = Intent(
                        SmartCalcApp.getAppInstance(),
                        BodyFatPercentageActivity::class.java
                    )
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_age,
                    title = "Age",
                    intent = Intent(SmartCalcApp.getAppInstance(), AgeActivity::class.java)
                )
            )

            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_time,
                    title = "Time",
                    intent = Intent(SmartCalcApp.getAppInstance(), TimeActivity::class.java)
                )
            )

//            itemList.add(
//                SearchItem(
//                    imageResource = 0,
//                    title = "",
//                    intent = null
//
//                )
//            )



            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_mileage,
                    title = "Mileage",
                    intent = Intent(SmartCalcApp.getAppInstance(), MileageActivity::class.java)
                )
            )


            itemList.add(
                SearchItem(
                    imageResource = R.drawable.ic_ohmlow,
                    title = "Ohm's Low",
                    intent = Intent(SmartCalcApp.getAppInstance(), OhmLawActivity::class.java)
                )
            )


            return itemList
        }

        fun getAllItemList(): ArrayList<SearchItem> {
            val itemList: ArrayList<SearchItem> = ArrayList()
            itemList.addAll(getAlgebraList())
            return itemList
        }
    }


}