package com.hannah.demo.ui.bookkeeping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookkeepingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is bookkeeping Fragment"
    }
    val text: LiveData<String> = _text
}