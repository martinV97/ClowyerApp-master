package com.dmd.martin.clowyer.login.presenter

import android.app.Activity

interface LoginPresenter {
    fun signIn(email: String, password: String, activity: Activity)
    fun loadDataAccount(id: String)
    fun loginSuccess()
    fun loadingDataError(error: String)
    fun loginError(error: String)
    fun showRegister()
}