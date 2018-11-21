package com.dmd.martin.clowyer.cardviews.cases.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenterImpl
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenter
import kotlinx.android.synthetic.main.fragment_case.*

class CaseFragment: Fragment(){

    private var navigationPresenter: NavigationPresenter? = null

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
        var adapter = CaseAdapterRecyclerView(Constants.listCases, activity, R.layout.cardview_case, navigationPresenter!!)
        recyclerCases.adapter = adapter
    }

    override fun onResume() {
        fillListCases()
        super.onResume()
    }

    fun setPresenter(navigationPresenter: NavigationPresenterImpl) {
        this.navigationPresenter = navigationPresenter
    }
}
