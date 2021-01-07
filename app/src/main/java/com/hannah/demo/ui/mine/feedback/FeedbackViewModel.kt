package com.hannah.demo.ui.mine.feedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.entity.Event

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
class FeedbackViewModel : ViewModel() {

    private val _submitFeedback = MutableLiveData<Event<Unit>>()
    val submitFeedback: LiveData<Event<Unit>> = _submitFeedback

    fun submit(){
        _submitFeedback.value = Event(Unit)
    }
}