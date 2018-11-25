package com.dmd.martin.clowyer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmd.martin.clowyer.R

class AddClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)
        showToolbar(getString(R.string.toolbar_title_create_client), true)
    }

    private fun showToolbar(title: String, upButton: Boolean){
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(upButton)
    }
}
