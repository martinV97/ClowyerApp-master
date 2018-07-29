package com.dmd.martin.clowyer.login.presenter

import com.dmd.martin.clowyer.login.interactor.LoginInteractor
import com.dmd.martin.clowyer.login.interactor.LoginInteractorImpl
import com.dmd.martin.clowyer.login.view.LoginView

class LoginPresenterImpl(private var loginView: LoginView) : LoginPresenter {

    private var interactor = LoginInteractorImpl(this)

    override fun signIn(email: String, password: String) {
        interactor.signIn(email, password)
    }

    override fun loginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}