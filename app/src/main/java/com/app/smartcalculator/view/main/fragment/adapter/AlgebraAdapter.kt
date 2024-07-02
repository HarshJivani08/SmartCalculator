package com.app.smartcalculator.view.main.fragment.adapter
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.smartcalculator.databinding.CardLayoutBinding
import com.app.smartcalculator.databinding.RawNativeTemplateBinding
import com.app.smartcalculator.model.DataList



class AlgebraAdapter(
    private var mList: ArrayList<DataList>,
    private val onItemClickListeners: OnItemClickListeners,
    private val activity: Activity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    interface OnItemClickListeners {
        fun onItemClick(data: DataList)
    }

    val TYPE_ITEM = 1
    val TYPE_ADS = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ADS) {
            val binding =
                RawNativeTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AdsHolder(binding)
        } else {
            val binding =
                CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mList[position].name.isEmpty()) {
            TYPE_ADS
        } else {
            TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val item = mList[position]

            holder.dataBinding.textViewName.text = item.name
            item.image?.let { holder.dataBinding.itemImg.setImageResource(it) }


            holder.binding.relativeLayout.setOnClickListener {
                onItemClickListeners.onItemClick(item)
            }

        } else if (holder is AdsHolder) {

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }



    class AdsHolder(var binding: RawNativeTemplateBinding) : RecyclerView.ViewHolder(binding.root) {
        var dataBinding = this.binding
    }

    class ViewHolder(var binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var dataBinding = this.binding
    }

}