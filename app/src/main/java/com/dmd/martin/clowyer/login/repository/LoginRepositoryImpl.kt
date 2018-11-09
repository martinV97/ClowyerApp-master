package com.dmd.martin.clowyer.login.repository

import android.app.Activity
import com.dmd.martin.clowyer.login.presenter.LoginPresenter
import com.google.firebase.auth.FirebaseAuth

class LoginRepositoryImpl(private var loginPresenter: LoginPresenter): LoginRepository {

    private var fireBaseAuth: FirebaseAuth? = null

    override fun signIn(email: String, password: String, activity: Activity) {
        fireBaseAuth = FirebaseAuth.getInstance()
        fireBaseAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful)
                loginPresenter!!.loginSuccess()
            else
                loginPresenter!!.loginError(it.exception!!.toString())
        }
    }
}