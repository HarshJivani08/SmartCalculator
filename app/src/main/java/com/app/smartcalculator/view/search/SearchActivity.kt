package com.app.smartcalculator.view.search
import SearchAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.app.smartcalculator.R
import com.app.smartcalculator.app.BaseActivity
import com.app.smartcalculator.databinding.ActivitySearchBinding
import com.app.smartcalculator.model.SearchItem
import com.app.smartcalculator.util.ListUtil


class SearchActivity : BaseActivity(), SearchAdapter.ItemClickListener,
    View.OnClickListener {

    private var binding: ActivitySearchBinding? = null
    var adapter: SearchAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initView()

        setClick()
        binding?.toolbar?.title?.text = getString(R.string.search)
    }

    private fun initView() {
        initSearch()
        adapter = SearchAdapter(this, this)
        adapter?.setList(ListUtil.getAllItemList())
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                var num = 0
                num = if (position % 3 == 0) 2
                else 1

                return num
            }
        }
        binding?.searchRec?.layoutManager = gridLayoutManager
        binding?.searchRec?.adapter = adapter
    }

    private fun initSearch() {
        binding?.edtSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                if (binding!!.edtSearch.text?.trim().toString().isEmpty()) {
                    adapter?.updateList(ListUtil.getAllItemList())
                } else {
                    filter(binding!!.edtSearch.text?.trim().toString())
                }
            }
        })
    }

    fun filter(text: String) {
        val temp: ArrayList<SearchItem> = ArrayList()
        temp.addAll(ListUtil.getAllItemList().filter { it.title.contains(text, true) })

        adapter?.updateList(temp)
    }

    override fun onItemClick(searchItem: SearchItem, position: Int) {
        startActivity(searchItem.intent)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_img -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    fun setClick() {
        binding?.toolbar?.backImg?.setOnClickListener(this)
    }
}