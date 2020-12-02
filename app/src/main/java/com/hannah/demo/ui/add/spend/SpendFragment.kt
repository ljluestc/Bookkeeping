package com.hannah.demo.ui.add.spend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hannah.demo.R
import com.hannah.demo.databinding.FragmentSpendBinding
import com.hannah.demo.entity.EventObserver
import com.hannah.demo.ui.add.AddItemFragment
import com.hannah.demo.ui.add.AddItemFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SpendFragment : Fragment() {

    private val spendViewModel by viewModels<SpendViewModel>()
    private lateinit var fragmentSpendBinding: FragmentSpendBinding
    private lateinit var listAdapter: SpendRecyclerListAdapter

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

        listAdapter = SpendRecyclerListAdapter(spendViewModel)
        fragmentSpendBinding.spendCategoryList.adapter = listAdapter

        spendViewModel.items.observe(viewLifecycleOwner, Observer {
            listAdapter.submitList(it)
        })

        spendViewModel.clickCategoryItemEvent.observe(viewLifecycleOwner, EventObserver {
            Timber.d("hui click item category 111--> ${it}")
        })

        spendViewModel.clickAddItemEvent.observe(viewLifecycleOwner, EventObserver{
            Timber.d("hui click foot item  222-->")
            navigateToAddNewClassification()
        })
    }

    private fun navigateToAddNewClassification() {
        val controller = findNavController()
        if(controller.currentDestination?.id == R.id.add_item_fragment_dest){
            val action = AddItemFragmentDirections.actionAddItemFragmentToAddNewClassificationFragment()
            controller.navigate(action)
        }
    }
}