package com.dmd.martin.clowyer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.services.consumeRest.CaseRest
import com.dmd.martin.clowyer.services.consumeRest.ClientRest
import com.dmd.martin.clowyer.services.consumeRest.CourtRest

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        CourtRest(this).execute()
        ClientRest(this).execute()
        CaseRest(this).execute()
    }
}
