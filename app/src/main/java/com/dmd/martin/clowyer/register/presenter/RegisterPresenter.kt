package com.dmd.martin.clowyer.register.presenter

import android.app.Activity

interface RegisterPresenter {
    fun register(email: String, password: String, activity: Activity)
    fun registerSuccess()
    fun registerError(error: String)
}