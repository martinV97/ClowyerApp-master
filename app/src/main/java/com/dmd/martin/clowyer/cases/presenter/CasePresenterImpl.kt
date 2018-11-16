package com.dmd.martin.clowyer.cases.presenter

import com.dmd.martin.clowyer.cardviews.cases.view.CaseView
import com.dmd.martin.clowyer.cases.interactor.CaseInteractorImpl

class CasePresenterImpl(var caseView: CaseView): CasePresenter {

    private var interactor = CaseInteractorImpl(this)

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