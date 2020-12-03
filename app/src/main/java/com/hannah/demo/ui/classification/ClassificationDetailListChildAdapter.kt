package com.hannah.demo.ui.classification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.databinding.ClassificationCategoryDetailChildBinding
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-12-02
 * 最底层的adapter
 */
class ClassificationDetailListChildAdapter(private val classificationViewModel: AddNewClassificationViewModel) :
    ListAdapter<CategoryEntity, ClassificationDetailListChildAdapter.ClassificationViewHolder>(
        ClassificationDiffCallback()
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClassificationViewHolder {
        return ClassificationViewHolder.fromNormal(parent)
    }

    override fun onBindViewHolder(holder: ClassificationViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, classificationViewModel)
    }

    class ClassificationViewHolder(private val binding: ClassificationCategoryDetailChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryEntity, classificationViewModel: AddNewClassificationViewModel) {
            binding.viewmodel = classificationViewModel
            binding.category = item
            binding.executePendingBindings()
        }
        companion object {
            fun fromNormal(parent: ViewGroup): ClassificationViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ClassificationCategoryDetailChildBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return ClassificationViewHolder(binding)
            }
        }
    }
}

class ClassificationDiffCallback : DiffUtil.ItemCallback<CategoryEntity>() {
    override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem == newItem
    }
}