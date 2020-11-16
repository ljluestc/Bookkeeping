package com.hannah.demo.ui.add.spend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.hannah.demo.R
import com.hannah.demo.factory.viewModelFactory
import com.hannah.demo.ui.bookkeeping.dummy.DummyContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryItemListFragment : Fragment() {

    private val spendViewModel by viewModels<SpendViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_category_list, container, false)
        setupRecyclerView(root.findViewById(R.id.category_list))
        return root
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        spendViewModel.categoryList.observe(viewLifecycleOwner,  Observer {
            recyclerView.adapter = SpendRecyclerListAdapter(it)
        })
    }
}