package com.hannah.demo.ui.add

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hannah.demo.ui.add.income.IncomeFragment
import com.hannah.demo.ui.add.spend.SpendFragment
import com.hannah.demo.utils.Constants.TAB_INCOME_PAGE_INDEX
import com.hannah.demo.utils.Constants.TAB_SPEND_PAGE_INDEX

class AddTabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        TAB_SPEND_PAGE_INDEX to { SpendFragment() },
        TAB_INCOME_PAGE_INDEX to { IncomeFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}