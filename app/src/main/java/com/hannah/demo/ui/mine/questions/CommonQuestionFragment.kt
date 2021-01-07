package com.hannah.demo.ui.mine.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hannah.demo.databinding.FragmentCommonQuestionBinding

class CommonQuestionFragment : Fragment() {

    private val questionViewModel by viewModels<CommonQuestionViewModel>()
    private lateinit var fragmentCommonQuestionBinding: FragmentCommonQuestionBinding
    private lateinit var questionAdapter: CommonQuestionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCommonQuestionBinding =
            FragmentCommonQuestionBinding.inflate(layoutInflater, container, false).apply {
                viewmodel = questionViewModel
            }
        fragmentCommonQuestionBinding.lifecycleOwner = this.viewLifecycleOwner
        return fragmentCommonQuestionBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        questionViewModel.questions.observe(viewLifecycleOwner, Observer {
            questionAdapter = CommonQuestionListAdapter(it, questionViewModel)
            questionAdapter.submitList(it)
            fragmentCommonQuestionBinding.questionList.adapter = questionAdapter
        })
    }

}