package com.hannah.demo.ui.bookkeeping

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hannah.demo.R

class BookkeepingViewModel(private val context: Context) : ViewModel() {

    private val _balance = MutableLiveData<String>().apply {
        value = context.getString(R.string.bookkeeping_balance)
    }

    private val _monthIncome = MutableLiveData<String>().apply {
        value = context.getString(R.string.bookkeeping_month_income)
    }

    private val _monthSpend = MutableLiveData<String>().apply {
        value = context.getString(R.string.bookkeeping_month_spend)
    }

    val balance: LiveData<String> = _balance
    val monthIncome: LiveData<String> = _monthIncome
    val monthSpend: LiveData<String> = _monthSpend

}