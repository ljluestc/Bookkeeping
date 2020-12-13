package com.hannah.demo.ui.classification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.R
import com.hannah.demo.databinding.ClassificationAccountBookListItemBinding
import com.hannah.demo.entity.AccountBook

/**
 * AUTHOR: hannah
 * DATE: 2020-12-02
 * 左边的adapter
 */
class ClassificationAccountBookListAdapter(
    private val books: List<AccountBook>,
    private val classificationViewModel: AddNewClassificationViewModel
) :
    RecyclerView.Adapter<ClassificationAccountBookListAdapter.AccountBookViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountBookViewHolder {
        return AccountBookViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AccountBookViewHolder, position: Int) {
        val item = books[position]
        holder.bind(item, classificationViewModel)
    }

    class AccountBookViewHolder(private val binding: ClassificationAccountBookListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AccountBook, classificationViewModel: AddNewClassificationViewModel) {
            binding.viewmodel = classificationViewModel
            binding.bookName = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): AccountBookViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ClassificationAccountBookListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return AccountBookViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = books.size
}

