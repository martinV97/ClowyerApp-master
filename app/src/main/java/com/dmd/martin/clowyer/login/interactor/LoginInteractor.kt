package com.dmd.martin.clowyer.login.interactor

import android.app.Activity

interface LoginInteractor {
    fun signIn(email: String, password: String, activity: Activity)
}