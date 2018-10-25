package com.dmd.martin.clowyer.register.interactor

import android.app.Activity
import com.dmd.martin.clowyer.register.presenter.RegisterPresenter
import com.dmd.martin.clowyer.register.repository.RegisterRepositoryImpl

class RegisterInteractorImpl(registerPresenter: RegisterPresenter): RegisterInteractor {
    private var loginRepository = RegisterRepositoryImpl(registerPresenter)

    override fun register(email: String, password: String, activity: Activity) {
        loginRepository.register(email, password, activity)
    }
}