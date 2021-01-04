package com.hannah.demo.ui.mine.login

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.hannah.demo.entity.Event
import com.hannah.demo.entity.LoginPlatform
import com.hannah.demo.utils.Constants

class LoginViewModel @ViewModelInject constructor(private val activity: Activity) : ViewModel() {

    private val _signInGoogle = MutableLiveData<Event<Unit>>()
    val signInGoogle: LiveData<Event<Unit>> = _signInGoogle

    private val _navToMine = MutableLiveData<FirebaseUser?>()
    val navToMine: LiveData<FirebaseUser?> = _navToMine

    fun signInGoogle(){
        _signInGoogle.value = Event(Unit)
    }

    private fun navToMineFunction(user: FirebaseUser?) {
        _navToMine.value = user
    }

    fun activityResultFromGoogleSignIn(requestCode: Int, data: Intent?) {
        if (requestCode == Constants.FIREBASE_GOOGLE_SIGN_IN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    firebaseAuthWithGoogleAndFacebook(LoginPlatform.GOOGLE, account.idToken!!)
                } catch (e: ApiException) {
                    Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun firebaseAuthWithGoogleAndFacebook(platform: LoginPlatform, idToken: String) {
        val credential = when (platform) {
            LoginPlatform.GOOGLE -> GoogleAuthProvider.getCredential(idToken, null)
            LoginPlatform.FACEBOOK -> FacebookAuthProvider.getCredential(idToken)
            else -> throw IllegalArgumentException("Login platform went wrong")
        }
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = FirebaseAuth.getInstance().currentUser
                    navToMineFunction(user)
                } else {
                    Toast.makeText(activity, task.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
    }

}