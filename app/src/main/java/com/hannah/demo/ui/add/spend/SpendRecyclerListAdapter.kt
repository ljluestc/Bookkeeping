package com.hannah.demo.ui.add.spend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.R
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-11-15
 */
class SpendRecyclerListAdapter(private val categories: List<CategoryEntity>) : RecyclerView.Adapter<SpendRecyclerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spend_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val categoryEntity: CategoryEntity = categories[position]
       holder.iconCategoryView.setBackgroundResource(R.drawable.ic_category_expense_food)
        holder.nameCategoryView.text = categoryEntity.name
    }

    override fun getItemCount(): Int = categories.size


    inner class ViewHolder(val view : View)  : RecyclerView.ViewHolder(view) {
        val iconCategoryView: ImageView = view.findViewById(R.id.img_category)
        val nameCategoryView: TextView = view.findViewById(R.id.name_category)
    }

}

