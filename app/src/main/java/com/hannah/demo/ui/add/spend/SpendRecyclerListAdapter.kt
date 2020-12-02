package com.hannah.demo.ui.add.spend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.databinding.SpendCategoryFootItemBinding
import com.hannah.demo.databinding.SpendCategoryListItemBinding
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.utils.Constants.TYPE_FOOT
import com.hannah.demo.utils.Constants.TYPE_SPEND

/**
 * AUTHOR: hannah
 * DATE: 2020-11-15
 */
class SpendRecyclerListAdapter(private val viewModel: SpendViewModel) :
    ListAdapter<CategoryEntity, SpendRecyclerListAdapter.NormalViewHolder>(SpendDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount - 1 -> TYPE_FOOT
            else -> TYPE_SPEND
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalViewHolder {
        return if (viewType == TYPE_FOOT) {
            NormalViewHolder.fromFoot(parent)
        } else {
            NormalViewHolder.fromNormal(parent)
        }
    }

    override fun onBindViewHolder(holder: NormalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, viewModel)
    }

    class NormalViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryEntity, viewModel: SpendViewModel) {
            if (binding is SpendCategoryListItemBinding) {
                binding.viewmodel = viewModel
                binding.category = item
            } else if (binding is SpendCategoryFootItemBinding) {
                binding.viewmodel = viewModel
            }
            binding.executePendingBindings()
        }

        companion object {
            fun fromNormal(parent: ViewGroup): NormalViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SpendCategoryListItemBinding.inflate(layoutInflater, parent, false)
                return NormalViewHolder(binding)
            }

            fun fromFoot(parent: ViewGroup): NormalViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SpendCategoryFootItemBinding.inflate(layoutInflater, parent, false)
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

