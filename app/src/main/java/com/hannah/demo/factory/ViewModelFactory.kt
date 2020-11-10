package com.hannah.demo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * AUTHOR: hannah
 * DATE: 2020-11-09
 */
inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
    }