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
import androidx.viewpager2.widget.ViewPager2
import com.hannah.demo.R
import com.hannah.demo.ui.add.AddTabPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpendFragment : Fragment() {

    private val spendViewModel by viewModels<SpendViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        spendViewModel = ViewModelProvider(this).get(SpendViewModel::class.java).apply {
//            setIndex(1)
//        }
//        spendViewModel.categoryList.observe(this, Observer {
//
//        })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tab, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
//        spendViewModel.text.observe(viewLifecycleOwner, Observer<String> {
//            textView.text = it
//        })
        val categoryViewPager = root.findViewById<ViewPager2>(R.id.category_view_pager)
        categoryViewPager.adapter = SpendPagerAdapter(this)
//        spendViewModel.categoryList.observe(viewLifecycleOwner, Observer {
//            textView.text = it[0].name
////            categoryViewPager.adapter = SpendRecyclerListAdapter(it)
//
//        })

        return root
    }

}