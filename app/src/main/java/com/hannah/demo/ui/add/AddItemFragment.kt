package com.hannah.demo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hannah.demo.R
import com.hannah.demo.utils.Constants.TAB_INCOME_PAGE_INDEX
import com.hannah.demo.utils.Constants.TAB_SPEND_PAGE_INDEX

class AddItemFragment : Fragment() {

    private val addItemViewModel by viewModels<AddItemViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add_item, container, false)

        val viewPager: ViewPager2 = root.findViewById(R.id.view_pager)
        viewPager.adapter = AddTabPagerAdapter(this)
        val tabs: TabLayout = root.findViewById(R.id.tabs)

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            TAB_SPEND_PAGE_INDEX -> getString(R.string.tab_spend)
            TAB_INCOME_PAGE_INDEX -> getString(R.string.tab_income)
            else -> null
        }
    }
}