package com.dmd.martin.clowyer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.ClientAdapterRecyclerView
import com.dmd.martin.clowyer.adapters.ClientItemAdapter
import com.dmd.martin.clowyer.constants.Constants
import kotlinx.android.synthetic.main.fragment_case.*
import kotlinx.android.synthetic.main.fragment_client.*

class ClientFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_client, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillListClient()
    }

    private fun fillListClient(){
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        recyclerClients.layoutManager = linearLayout
        var adapter = ClientAdapterRecyclerView(Constants.listClients, activity, R.layout.cardview_client)
        recyclerClients.adapter = adapter
    }

    override fun onResume() {
        fillListClient()
        super.onResume()
    }
}
