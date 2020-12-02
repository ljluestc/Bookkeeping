package com.hannah.demo.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.entity.Event

class AddItemViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Fragment"
    }
    val text: LiveData<String> = _text


    private val _openSpendEvent = MutableLiveData<Event<Unit>>()
    val openSpendEvent: LiveData<Event<Unit>> = _openSpendEvent

    fun openSpendFragment() {
        _openSpendEvent.value = Event(Unit)
    }
}