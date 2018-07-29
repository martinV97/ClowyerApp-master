package com.dmd.martin.clowyer.login.interactor

import com.dmd.martin.clowyer.login.presenter.LoginPresenter
import com.dmd.martin.clowyer.login.repository.LoginRepositoryImpl

class LoginInteractorImpl(private var loginPresenter: LoginPresenter): LoginInteractor {

    private var loginRepository = LoginRepositoryImpl(loginPresenter)

    override fun signIn(email: String, password: String) {
        loginRepository.signIn(email, password)
    }
}