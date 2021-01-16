package com.hannah.demo.ui.mine.feedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hannah.demo.utils.Constants.DEFAULT_ADVICE
import com.hannah.demo.utils.Constants.DEFAULT_PHONE
import kotlinx.coroutines.launch

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
class FeedbackViewModel : ViewModel() {

    val advice = MutableLiveData<String>()
    val phone = MutableLiveData<String>()

    private val _submitStatus = MutableLiveData<Boolean>()
    val submitStatus: LiveData<Boolean> = _submitStatus

    fun submit() {
        val phoneUser = phone.value ?: DEFAULT_PHONE
        val adviceUser = advice.value ?: DEFAULT_ADVICE

        val db = Firebase.firestore
        val feedback = hashMapOf(
            "advice" to adviceUser,
            "phone" to phoneUser
        )
        viewModelScope.launch {
            db.collection("feedbacks").add(feedback)
                .addOnSuccessListener {
                    _submitStatus.value = true
                }
                .addOnFailureListener {
                    _submitStatus.value = false
                }
        }
    }

}