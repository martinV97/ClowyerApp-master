package com.dmd.martin.clowyer.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.CaseActivity
import com.dmd.martin.clowyer.activities.LoadActivity
import com.dmd.martin.clowyer.adapters.CaseItemAdapter
import com.dmd.martin.clowyer.constants.Constants
import kotlinx.android.synthetic.main.activity_case.*
import kotlinx.android.synthetic.main.fragment_case.*

class CaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_case, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillListCases()
    }

    private fun fillListCases(){
        listCase.adapter = CaseItemAdapter(this.context!!, Constants.listCases!!)
    }


    override fun onResume() {
        fillListCases()
        super.onResume()
    }
}
