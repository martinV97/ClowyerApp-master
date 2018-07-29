package com.dmd.martin.clowyer.login.presenter

import com.dmd.martin.clowyer.login.interactor.LoginInteractor
import com.dmd.martin.clowyer.login.interactor.LoginInteractorImpl
import com.dmd.martin.clowyer.login.view.LoginView

class LoginPresenterImpl(private var loginView: LoginView) : LoginPresenter {

    private var interactor = LoginInteractorImpl(this)

    override fun signIn(email: String, password: String) {
        loginView.disableInputs()
        loginView.showProgressBar()
        interactor.signIn(email, password)
    }

    override fun loginSuccess() {
        loginView.hideProgressBar()
        loginView.showMain()
    }

    override fun loginError(error: String) {
        loginView.enableInputs()
        loginView.hideProgressBar()
        loginView.loginError(error)
    }
}