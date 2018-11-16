package com.dmd.martin.clowyer.login.interactor

import android.app.Activity
import com.dmd.martin.clowyer.login.presenter.LoginPresenter
import com.dmd.martin.clowyer.login.repository.LoginRepositoryImpl

class LoginInteractorImpl(private var loginPresenter: LoginPresenter): LoginInteractor {

    private var loginRepository = LoginRepositoryImpl(loginPresenter)

    override fun signIn(email: String, password: String, activity: Activity) {
        loginRepository.signIn(email, password, activity)
    }

    override fun loadDataAccount(id: String) {
        loginRepository.loadCases(id)
        loginRepository.loadClients(id)
        loginRepository.loadCourts()
    }
}