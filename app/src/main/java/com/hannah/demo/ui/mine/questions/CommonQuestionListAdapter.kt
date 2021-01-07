package com.hannah.demo.ui.mine.questions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.databinding.CommonQuestionListItemBinding
import com.hannah.demo.entity.QuestionEntity

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
class CommonQuestionListAdapter(
    private val data: List<QuestionEntity>,
    private val viewModel: CommonQuestionViewModel
) :
    ListAdapter<QuestionEntity, CommonQuestionListAdapter.QuestionViewHolder>(
        CommonQuestionDiffCallback()
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionViewHolder {
        return QuestionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, viewModel)
    }

    class QuestionViewHolder(private val binding: CommonQuestionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: QuestionEntity,
            viewModel: CommonQuestionViewModel
        ) {
            binding.questionEntity = item
            binding.viewmodel = viewModel
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): QuestionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CommonQuestionListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return QuestionViewHolder(binding)
            }
        }
    }
}

class CommonQuestionDiffCallback : DiffUtil.ItemCallback<QuestionEntity>() {
    override fun areItemsTheSame(oldItem: QuestionEntity, newItem: QuestionEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: QuestionEntity, newItem: QuestionEntity): Boolean {
        return oldItem == newItem
    }
}