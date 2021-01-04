package com.hannah.demo.ui.mine.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseUser
import com.hannah.demo.R
import com.hannah.demo.databinding.FragmentLoginBinding
import com.hannah.demo.entity.EventObserver
import com.hannah.demo.entity.LoginPlatform
import com.hannah.demo.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var callbackManager: CallbackManager

    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding =
            FragmentLoginBinding.inflate(layoutInflater, container, false).apply {
                viewmodel = loginViewModel
            }
        return fragmentLoginBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupGoogleSignInConfiguration()
        setupFacebookConfiguration()
        loginViewModel.signInGoogle.observe(viewLifecycleOwner, EventObserver {
            signInWithGoogle()
        })
        loginViewModel.navToMine.observe(viewLifecycleOwner, Observer{
            it?.let {
                navigateToMineFragment(it)
            }
        })
    }

    private fun setupFacebookConfiguration() {
        fragmentLoginBinding.loginButton.setPermissions("email", "public_profile")
        fragmentLoginBinding.loginButton.fragment = this
        fragmentLoginBinding.loginButton.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                loginViewModel.firebaseAuthWithGoogleAndFacebook(
                    LoginPlatform.FACEBOOK,
                    loginResult.accessToken.token
                )
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException) {
            }
        })
    }

    private fun setupGoogleSignInConfiguration() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        callbackManager = CallbackManager.Factory.create()
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, Constants.FIREBASE_GOOGLE_SIGN_IN_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        loginViewModel.activityResultFromGoogleSignIn(requestCode, data)
    }

    private fun navigateToMineFragment(user: FirebaseUser?) {
        val action = LoginFragmentDirections.actionLoginFragmentToMineFragment(user)
        findNavController().navigate(action)
    }
}

