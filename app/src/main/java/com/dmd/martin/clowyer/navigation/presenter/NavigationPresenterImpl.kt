package com.dmd.martin.clowyer.navigation.presenter

import com.dmd.martin.clowyer.navigation.interactor.NavigationInteractorImpl
import com.dmd.martin.clowyer.navigation.view.NavigationView

class NavigationPresenterImpl(var navigationView: NavigationView): NavigationPresenter {

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

    override fun showCreateCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchClient() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteClient() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateClients() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showClient() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCreateClient() {
        navigationView.showCreateClient()
    }

    override fun searchCourt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteCourt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCourts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCourt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCreateCourt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}