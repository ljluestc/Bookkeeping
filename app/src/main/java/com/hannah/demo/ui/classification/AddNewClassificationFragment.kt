package com.hannah.demo.ui.classification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hannah.demo.databinding.FragmentAddNewClassificationBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * AUTHOR: hannah
 * DATE: 2020-12-01
 */
@AndroidEntryPoint
class AddNewClassificationFragment : Fragment(){

    private val classificationViewModel by viewModels<AddNewClassificationViewModel>()
    private lateinit var addClassificationBinding: FragmentAddNewClassificationBinding

    private lateinit var leftAdapter: ClassificationAccountBookListAdapter
    private lateinit var rightAdapter: ClassificationDetailListAdapter
    private lateinit var rightChildAdapter: ClassificationDetailListChildAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addClassificationBinding = FragmentAddNewClassificationBinding.inflate(inflater, container, false).apply {
            viewmodel = classificationViewModel
        }
        addClassificationBinding.lifecycleOwner = this.viewLifecycleOwner

        return addClassificationBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        classificationViewModel.books.observe(viewLifecycleOwner, Observer {
            leftAdapter = ClassificationAccountBookListAdapter(it, classificationViewModel)
            addClassificationBinding.accountBookList.adapter = leftAdapter
        })

        classificationViewModel.classifications.observe(viewLifecycleOwner, Observer {
            rightChildAdapter = ClassificationDetailListChildAdapter(classificationViewModel)
            rightAdapter = ClassificationDetailListAdapter(it, rightChildAdapter, classificationViewModel)
            addClassificationBinding.categoryDetailList.adapter = rightAdapter
        })
    }
}