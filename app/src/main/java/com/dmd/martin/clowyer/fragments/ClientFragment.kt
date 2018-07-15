package com.dmd.martin.clowyer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.ClientItemAdapter
import com.dmd.martin.clowyer.constants.Constants
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
        listClient.adapter = ClientItemAdapter(this.context!!, Constants.listClients!!)
    }

    override fun onResume() {
        fillListClient()
        super.onResume()
    }
}
