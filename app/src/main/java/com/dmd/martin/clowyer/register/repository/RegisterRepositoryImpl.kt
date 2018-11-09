package com.dmd.martin.clowyer.register.repository

import android.app.Activity

import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.register.presenter.RegisterPresenter
import com.google.firebase.auth.FirebaseAuth

class RegisterRepositoryImpl(private var registerPresenter: RegisterPresenter): RegisterRepository {

    private var fireBaseAuth: FirebaseAuth? = null

    override fun register(email: String, password: String, activity: Activity) {
        fireBaseAuth = FirebaseAuth.getInstance()
        fireBaseAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(activity, activity.getString(R.string.create_account_succesfull), Toast.LENGTH_SHORT).show()
                registerPresenter.registerSuccess()
            }else
                registerPresenter.registerError(it.exception!!.message!!)
        }
    }
}