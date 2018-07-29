package com.dmd.martin.clowyer.login.interactor

interface LoginInteractor {
    fun signIn(email: String, password: String)
}