package com.dmd.martin.clowyer.register.presenter

import android.app.Activity
import com.dmd.martin.clowyer.register.interactor.RegisterInteractorImpl
import com.dmd.martin.clowyer.register.view.RegisterView

class RegisterPresenterImpl(private var registerView: RegisterView): RegisterPresenter {
    private var interactor = RegisterInteractorImpl(this)

    override fun register(email: String, password: String, activity: Activity) {
        registerView.disableInputs()
        registerView.showProgressBar()
        interactor.register(email, password, activity)
    }

    override fun registerSuccess() {
        registerView.hideProgressBar()
        registerView.showMain()
    }

    override fun registerError(error: String) {
        registerView.enableInputs()
        registerView.hideProgressBar()
        registerView.registerError(error)
    }
}