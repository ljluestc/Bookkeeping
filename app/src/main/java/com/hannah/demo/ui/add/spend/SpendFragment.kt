package com.hannah.demo.ui.add.spend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hannah.demo.databinding.FragmentSpendBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpendFragment : Fragment() {

    private val spendViewModel by viewModels<SpendViewModel>()
    private lateinit var fragmentSpendBinding: FragmentSpendBinding
    private lateinit var listAdapter: SpendRecyclerListAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSpendBinding = FragmentSpendBinding.inflate(inflater, container, false).apply {
            viewmodel = spendViewModel
        }
        fragmentSpendBinding.lifecycleOwner = this.viewLifecycleOwner
        return fragmentSpendBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listAdapter = SpendRecyclerListAdapter2()
        fragmentSpendBinding.spendCategoryList.adapter = listAdapter

        spendViewModel.items.observe(viewLifecycleOwner, Observer {
            listAdapter.submitList(it)
        })
    }

}