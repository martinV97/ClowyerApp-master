package com.dmd.martin.clowyer.register.repository

import android.app.Activity
import com.dmd.martin.clowyer.register.presenter.RegisterPresenter

class RegisterRepositoryImpl(private var registerPresenter: RegisterPresenter): RegisterRepository {

    override fun register(email: String, password: String, activity: Activity) {

    }
}