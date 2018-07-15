package com.dmd.martin.clowyer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.entity.ItemCase
import com.dmd.martin.clowyer.services.consumeRest.DocRest

class LoadCaseActivity : AppCompatActivity() {

    private var case: ItemCase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_case)
        case = intent.extras.getSerializable("Item") as ItemCase
        DocRest(this, case!!.getNumber()).execute()
    }
}
