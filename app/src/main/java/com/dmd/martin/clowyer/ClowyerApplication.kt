package com.dmd.martin.clowyer

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

class ClowyerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}