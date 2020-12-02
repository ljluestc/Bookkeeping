package com.hannah.demo.ui.classification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * AUTHOR: hannah
 * DATE: 2020-12-01
 */
class AddNewClassificationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Fragment"
    }
    val text: LiveData<String> = _text
}