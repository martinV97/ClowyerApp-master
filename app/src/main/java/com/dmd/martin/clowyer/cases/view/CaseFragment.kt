package com.dmd.martin.clowyer.cardviews.cases.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.cases.presenter.CasePresenter
import com.dmd.martin.clowyer.cases.presenter.CasePresenterImpl
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.entity.ItemCase
import kotlinx.android.synthetic.main.fragment_case.*

class CaseFragment : Fragment(), CaseView {

    private var casePresenter = CasePresenterImpl(this)

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
        var adapter = CaseAdapterRecyclerView(Constants.listCases, activity, R.layout.cardview_case, casePresenter)
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
}
