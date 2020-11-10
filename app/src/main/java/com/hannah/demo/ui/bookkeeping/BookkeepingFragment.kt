package com.hannah.demo.ui.bookkeeping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.hannah.demo.R
import com.hannah.demo.factory.viewModelFactory
import com.hannah.demo.ui.bookkeeping.dummy.DummyContent

class BookkeepingFragment : Fragment() {

    private lateinit var homeViewModel: BookkeepingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(
            this,
            viewModelFactory { BookkeepingViewModel(requireContext()) }).get(BookkeepingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bookkeeping, container, false)

        val balance: TextView = root.findViewById(R.id.money_balance)
        homeViewModel.balance.observe(viewLifecycleOwner, Observer {
            balance.text = it
        })

        val monthIncome: TextView = root.findViewById(R.id.month_income)
        homeViewModel.monthIncome.observe(viewLifecycleOwner, Observer {
            monthIncome.text = it
        })

        val monthSpend: TextView = root.findViewById(R.id.month_spend)
        homeViewModel.monthSpend.observe(viewLifecycleOwner, Observer {
            monthSpend.text = it
        })

        root.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setupRecyclerView(root.findViewById(R.id.bookkeeping_list))
        return root
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = BookkeepingAdapter(DummyContent.ITEMS)
    }
}