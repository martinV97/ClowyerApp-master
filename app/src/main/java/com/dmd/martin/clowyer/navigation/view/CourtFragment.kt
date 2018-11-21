package com.dmd.martin.clowyer.navigation.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.CourtAdapterRecyclerView
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenter
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenterImpl
import kotlinx.android.synthetic.main.fragment_court.*

class CourtFragment: Fragment(){

    private var navigationPresenter: NavigationPresenterImpl? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_court, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillListCourts()
    }

    private fun fillListCourts(){
        var linearLayout = LinearLayoutManager(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        recyclerCourt.layoutManager = linearLayout
        var adapter = CourtAdapterRecyclerView(Constants.listCourts, activity, R.layout.cardview_court)
        recyclerCourt.adapter = adapter
    }

    override fun onResume() {
        fillListCourts()
        super.onResume()
    }

    fun setPresenter(navigationPresenter: NavigationPresenterImpl) {
        this.navigationPresenter = navigationPresenter
    }
}
