package com.dmd.martin.clowyer.login.repository

import com.dmd.martin.clowyer.login.presenter.LoginPresenter

class LoginRepositoryImpl(private var loginPresenter: LoginPresenter): LoginRepository {

    override fun signIn(email: String, password: String) {
        var success = true
        if(success)
            loginPresenter!!.loginSuccess()
        else
            loginPresenter!!.loginError("Error iniciando sesión.")
    }
}