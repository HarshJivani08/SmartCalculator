package com.app.smartcalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.app.smartcalculator.app.SmartCalcApp.Companion.getAppInstance
import com.app.smartcalculator.databinding.NavDrawerBinding
import com.app.smartcalculator.model.NavBean
import com.bumptech.glide.Glide

class NavDrawerAdapter(
    val context: Context,
    val list: ArrayList<NavBean>,
    private val onItemClickListeners: OnItemClickListeners
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListeners {
        fun onItemClick(data: NavBean, adapterPosition: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = NavDrawerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = list[position]
        if (holder is ItemViewHolder) {
            holder.dataBinding.title.text = data.title
            Glide.with(context).load(data.icon).into(holder.dataBinding.image)
            holder.itemView.setOnClickListener {
                onItemClickListeners.onItemClick(data, position)
            }

            if (data.isvisibility) {
                holder.dataBinding.customSwitch.visibility = View.VISIBLE
            } else {
                holder.dataBinding.customSwitch.visibility = View.GONE
            }


            holder.dataBinding.customSwitch.isChecked =
                getAppInstance().getDarkMode()

            holder.dataBinding.customSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                getAppInstance().saveDarkMode(isChecked)
                if (isChecked) {
                    holder.dataBinding.customSwitch.isEnabled
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    class ItemViewHolder(var binding: NavDrawerBinding) : RecyclerView.ViewHolder(binding.root) {
        var dataBinding = this.binding
    }

}


