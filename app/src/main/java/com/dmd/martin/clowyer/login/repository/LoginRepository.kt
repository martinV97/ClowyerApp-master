package com.dmd.martin.clowyer.login.repository

import android.app.Activity

interface LoginRepository {
    fun signIn(email: String, password: String, activity: Activity)
}