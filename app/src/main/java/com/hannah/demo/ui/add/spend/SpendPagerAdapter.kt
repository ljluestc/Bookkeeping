package com.hannah.demo.ui.add.spend

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hannah.demo.ui.add.income.IncomeFragment
import com.hannah.demo.ui.add.spend.SpendFragment
import com.hannah.demo.utils.Constants.TAB_INCOME_PAGE_INDEX
import com.hannah.demo.utils.Constants.TAB_SPEND_PAGE_INDEX

class SpendPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return CategoryItemListFragment()
    }
}