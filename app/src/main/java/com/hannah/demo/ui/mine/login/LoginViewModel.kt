package com.hannah.demo.ui.mine.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.entity.Event

class LoginViewModel : ViewModel() {

    private val _signInGoogle = MutableLiveData<Event<Unit>>()
    val signInGoogle: LiveData<Event<Unit>> = _signInGoogle

    private val _noUserLogin = MutableLiveData<String>()
    val noUserLogin: LiveData<String> = _noUserLogin

    fun signInGoogle(){
        _signInGoogle.value = Event(Unit)
    }





}