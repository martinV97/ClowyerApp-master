package com.dmd.martin.clowyer.login.presenter

import android.app.Activity
import com.dmd.martin.clowyer.login.interactor.LoginInteractor
import com.dmd.martin.clowyer.login.interactor.LoginInteractorImpl
import com.dmd.martin.clowyer.login.view.LoginView

class LoginPresenterImpl(private var loginView: LoginView) : LoginPresenter {

    private var interactor = LoginInteractorImpl(this)

    override fun signIn(email: String, password: String, activity: Activity) {
        loginView.disableInputs()
        loginView.showProgressBar()
        interactor.signIn(email, password, activity)
    }

    override fun loadDataAccount(id: String) {
        loginView.showLoadingText()
        interactor.loadDataAccount(id)
    }

    override fun loginSuccess() {
        loginView.hideProgressBar()
        loginView.hideLoadingText()
        loginView.showMain()
    }

    override fun loadingDataError(error: String) {
        loginView.enableInputs()
        loginView.hideProgressBar()
        loginView.hideLoadingText()
        loginView.loginError(error)
    }

    override fun loginError(error: String) {
        loginView.enableInputs()
        loginView.hideProgressBar()
        loginView.loginError(error)
    }

    override fun showRegister() {
        loginView.showRegister()
    }
}