package com.dmd.martin.clowyer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast


import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.CaseAdapterRecyclerView
import com.dmd.martin.clowyer.constants.Constants
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
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        recyclerCases.layoutManager = linearLayout
        var adapter = CaseAdapterRecyclerView(Constants.listCases, activity, R.layout.cardview_case)
        recyclerCases.adapter = adapter
        recyclerCases.setOnClickListener{
            var position = recyclerCases.indexOfChild(view)
            Toast.makeText(context, Constants.listCases[position].getName(), Toast.LENGTH_SHORT).show()
        }
    }


    override fun onResume() {
        fillListCases()
        super.onResume()
    }
}
