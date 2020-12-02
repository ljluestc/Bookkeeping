package com.hannah.demo.ui.classification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannah.demo.databinding.FragmentAddNewClassificationBinding

/**
 * AUTHOR: hannah
 * DATE: 2020-12-01
 */
class AddNewClassificationFragment : Fragment(){

    private val classificationViewModel by viewModels<AddNewClassificationViewModel>()
    private lateinit var fragmentSpendBinding: FragmentAddNewClassificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSpendBinding = FragmentAddNewClassificationBinding.inflate(inflater, container, false).apply {
            viewmodel = classificationViewModel
        }
        fragmentSpendBinding.lifecycleOwner = this.viewLifecycleOwner
        return fragmentSpendBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}