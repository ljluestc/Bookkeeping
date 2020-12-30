package com.hannah.demo.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.entity.Event

class MineViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mine Fragment"
    }
    val text: LiveData<String> = _text

    private val _openLoginRegister = MutableLiveData<Event<Unit>>()
    val openLoginRegister: LiveData<Event<Unit>> = _openLoginRegister

    private val _openCommonQuestion = MutableLiveData<Event<Unit>>()
    val openCommonQuestion: LiveData<Event<Unit>> = _openCommonQuestion

    fun openLoginRegister(){
        _openLoginRegister.value = Event(Unit)
    }

    fun jumpToCommonQuestionPage(){
        _openCommonQuestion.value = Event(Unit)
    }



}