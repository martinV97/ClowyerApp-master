package com.dmd.martin.clowyer.login.presenter

interface LoginPresenter {
    fun signIn(email: String, password: String)
    fun loginSuccess()
    fun loginError(error: String)
}