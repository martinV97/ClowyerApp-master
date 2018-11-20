package com.dmd.martin.clowyer.navigation.presenter

import com.dmd.martin.clowyer.cardviews.cases.view.CaseNavigationView
import com.dmd.martin.clowyer.navigation.interactor.NavigationInteractorImpl
import com.dmd.martin.clowyer.navigation.view.ClientNavigationView
import com.dmd.martin.clowyer.navigation.view.CourtNavigationView

class NavigationPresenterImpl(var caseNavigationView: CaseNavigationView,
                              var clientNavigationView: ClientNavigationView,
                              var courtNavigationView: CourtNavigationView): NavigationPresenter {

    private var interactor = NavigationInteractorImpl(this)

    override fun searchCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCases() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}