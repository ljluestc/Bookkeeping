package com.hannah.demo.ui.classification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.databinding.ClassificationCategoryDetailListItemBinding
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.ClassificationEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-12-02
 * 右边的的adapter
 */
class ClassificationDetailListAdapter(
    private val data: List<ClassificationEntity>,
    private val childAdapter: ClassificationDetailListChildAdapter,
    private val classificationViewModel: AddNewClassificationViewModel
) :
    RecyclerView.Adapter<ClassificationDetailListAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        return DetailViewHolder.fromNormal(parent)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = data[position]
        val childList = data[position].categories
        holder.bind(item, childList, childAdapter, classificationViewModel)
    }

    class DetailViewHolder(private val binding: ClassificationCategoryDetailListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: ClassificationEntity,
            childList: List<CategoryEntity>,
            adapter: ClassificationDetailListChildAdapter,
            classificationViewModel: AddNewClassificationViewModel
        ) {
            binding.viewmodel = classificationViewModel
            binding.classification = item
            binding.categoryAllDetailList.adapter = adapter
            adapter.submitList(childList)
            binding.executePendingBindings()
        }

        companion object {
            fun fromNormal(parent: ViewGroup): DetailViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ClassificationCategoryDetailListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return DetailViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

