package com.dmd.martin.clowyer.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.constants.Constants
import kotlinx.android.synthetic.main.activity_case.*
import android.support.v7.widget.GridLayoutManager
import com.dmd.martin.clowyer.adapters.DocAdapterRecyclerView


class CaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case)
        fillListDoc()
        openAddDoc()
        backFab()
    }

    private fun fillListDoc(){
        var gridLayout = GridLayoutManager(baseContext, 2)
        gridLayout.orientation = GridLayoutManager.VERTICAL
        recyclerDoc.layoutManager = gridLayout
        var adapter = DocAdapterRecyclerView(Constants.listDocs, this, R.layout.cardview_doc)
        recyclerDoc.adapter = adapter
    }

    private fun openAddDoc(){
        fabAddDoc.setOnClickListener {
            startActivity(Intent(this, AddDocActivity::class.java))
        }
    }

    private fun backFab(){
        fabBackCase.setOnClickListener {
            Constants.listDocs = arrayListOf()
            this.finish()
        }
    }
}
