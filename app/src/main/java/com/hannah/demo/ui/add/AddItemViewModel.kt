package com.hannah.demo.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Fragment"
    }
    val text: LiveData<String> = _text
}