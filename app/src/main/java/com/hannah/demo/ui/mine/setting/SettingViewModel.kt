package com.hannah.demo.ui.mine.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.BuildConfig

class SettingViewModel : ViewModel() {

    private val _version = MutableLiveData<String>().apply {
        value = "V ${BuildConfig.VERSION_NAME} "
    }
    val version: LiveData<String> = _version
}