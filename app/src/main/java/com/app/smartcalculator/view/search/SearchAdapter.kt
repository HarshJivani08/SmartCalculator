import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.smartcalculator.databinding.CardLayoutBinding
import com.app.smartcalculator.model.SearchItem


class SearchAdapter(private val listener: ItemClickListener, var activity: Activity ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var dataList: ArrayList<SearchItem> = ArrayList()

    val TYPE_ITEM = 1

    interface ItemClickListener {
        fun onItemClick(searchItem: SearchItem, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataList[position]
//
//        holder.binding.itemImg.setImageResource(item.imageResource)
//        holder.binding.textViewName.text = item.title
//
//        holder.binding.relativeLayout.setOnClickListener{
//            listener.onItemClick(item , position)
//        }
//
//    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val item = dataList[position]

            holder.binding.itemImg.setImageResource(item.imageResource)
            holder.binding.textViewName.text = item.title

            holder.binding.relativeLayout.setOnClickListener {
                listener.onItemClick(item, position)
            }

        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    fun updateList(list: ArrayList<SearchItem>) {
        dataList = list
        notifyDataSetChanged()
    }

    fun setList(list: ArrayList<SearchItem>) {
        dataList = list
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var dataBinding = this.binding
    }

}