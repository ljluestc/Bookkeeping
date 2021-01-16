package com.hannah.demo.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.hannah.demo.entity.Event
import com.hannah.demo.utils.Constants.USER_LOGIN_DEFAULT

class MineViewModel : ViewModel() {

    private var _userName = MutableLiveData<String>().apply {
        this.value = USER_LOGIN_DEFAULT
    }
    var userName: LiveData<String> = _userName

    private var _avatarUrl = MutableLiveData<String>()
    var avatarUrl: LiveData<String> = _avatarUrl

    private val _openLoginRegister = MutableLiveData<Event<Unit>>()
    val openLoginRegister: LiveData<Event<Unit>> = _openLoginRegister

    private val _openCommonQuestion = MutableLiveData<Event<Unit>>()
    val openCommonQuestion: LiveData<Event<Unit>> = _openCommonQuestion

    private val _openFeedback = MutableLiveData<Event<Unit>>()
    val openFeedback: LiveData<Event<Unit>> = _openFeedback

    private val _openSetting = MutableLiveData<Event<Unit>>()
    val openSetting: LiveData<Event<Unit>> = _openSetting

    fun openLoginRegister() {
        _openLoginRegister.value = Event(Unit)
    }

    fun jumpToCommonQuestionPage() {
        _openCommonQuestion.value = Event(Unit)
    }

    fun jumpToFeedbackPage() {
        _openFeedback.value = Event(Unit)
    }

    fun jumpToSettingPage() {
        _openSetting.value = Event(Unit)
    }

    fun updateUser(user: FirebaseUser?) {
        _userName.value = user?.displayName
        _avatarUrl.value = user?.photoUrl?.toString()
    }

}