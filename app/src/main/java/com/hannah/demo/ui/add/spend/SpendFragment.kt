package com.hannah.demo.ui.add.spend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.R
import com.hannah.demo.entity.CategoryEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpendFragment : Fragment(), View.OnClickListener {

    private val spendViewModel by viewModels<SpendViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tab, container, false)
        val categoryName: TextView = root.findViewById(R.id.category_choose_text)
        val categoryIcon: ImageView = root.findViewById(R.id.category_choose_icon)
        spendViewModel.item.observe(viewLifecycleOwner, Observer {
            categoryName.text = it.name
            categoryIcon.setBackgroundResource(it.icon)
        })
        setupRecyclerView(root.findViewById(R.id.spend_category_list))
        return root
    }


    private fun setupRecyclerView(recyclerView: RecyclerView) {
        spendViewModel.categoryList.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = SpendRecyclerListAdapter(it, onClickListener = this)
        })
    }

    override fun onClick(view: View) {
        val categoryEntity = view.tag as CategoryEntity
        spendViewModel.item.value = categoryEntity
    }

}