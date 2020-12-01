package com.hannah.demo.ui.add.spend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.databinding.SpendCategoryListItemBinding
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-11-15
 */
class SpendRecyclerListAdapter(private val viewModel: SpendViewModel):
    ListAdapter<CategoryEntity, SpendRecyclerListAdapter.NormalViewHolder>(SpendDiffCallback()) {

    companion object {
        private const val TYPE_NORMAL = 0
        private const val TYPE_FOOT = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalViewHolder {
        return NormalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NormalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, viewModel)
    }

    class NormalViewHolder private constructor(private val binding: SpendCategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryEntity, viewModel: SpendViewModel) {
            binding.viewmodel = viewModel
            binding.category = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NormalViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SpendCategoryListItemBinding.inflate(layoutInflater, parent, false)
                return NormalViewHolder(binding)
            }
        }
    }
}

class SpendDiffCallback : DiffUtil.ItemCallback<CategoryEntity>() {
    override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem == newItem
    }
}

