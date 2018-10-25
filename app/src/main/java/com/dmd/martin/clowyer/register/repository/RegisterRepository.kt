package com.dmd.martin.clowyer.register.repository

import android.app.Activity

interface RegisterRepository {
    fun register(email: String, password: String, activity: Activity)
}