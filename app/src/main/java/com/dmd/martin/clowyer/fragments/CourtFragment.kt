package com.dmd.martin.clowyer.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.CourtItemAdapter
import com.dmd.martin.clowyer.constants.Constants
import kotlinx.android.synthetic.main.fragment_court.*

class CourtFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_court, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillListCourts()
    }

    private fun fillListCourts(){
        listCourt.adapter = CourtItemAdapter(this.context!!, Constants.listCourts!!)
    }

    override fun onResume() {
        fillListCourts()
        super.onResume()
    }


}
