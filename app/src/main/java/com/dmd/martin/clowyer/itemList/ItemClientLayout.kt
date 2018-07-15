package com.dmd.martin.clowyer.itemList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmd.martin.clowyer.R
import kotlinx.android.synthetic.main.fragment_case.*


class ItemClientLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_item)
        fabCase.setOnClickListener {

        }
    }
}