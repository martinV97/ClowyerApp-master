package com.dmd.martin.clowyer.cardviews.cases.view

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
import com.dmd.martin.clowyer.entity.ItemCase
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenter
import kotlinx.android.synthetic.main.fragment_case.*

class CaseFragment : Fragment(), CaseNavigationView {

    private var navigationPresenterImpl: NavigationPresenter? = null

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
        var adapter = CaseAdapterRecyclerView(Constants.listCases, activity, R.layout.cardview_case, navigationPresenterImpl!!)
        recyclerCases.adapter = adapter
    }

    override fun onResume() {
        fillListCases()
        super.onResume()
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCase(case: ItemCase) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSearchError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDeleteError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setPresenter(navigationPresenter: NavigationPresenterImpl){
        this.navigationPresenterImpl = navigationPresenter
    }
}
