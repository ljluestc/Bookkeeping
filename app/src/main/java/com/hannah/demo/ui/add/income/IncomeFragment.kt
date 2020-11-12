package com.hannah.demo.ui.add.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hannah.demo.R


class IncomeFragment : Fragment() {

    private lateinit var incomeViewModel: IncomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        incomeViewModel = ViewModelProvider(this).get(IncomeViewModel::class.java).apply {
            setIndex(2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tab, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        incomeViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }

}