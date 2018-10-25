package com.dmd.martin.clowyer.register.interactor

import android.app.Activity

interface RegisterInteractor {
    fun register(email: String, password: String, activity: Activity)
}