package com.dmd.martin.clowyer.cases.interactor

import com.dmd.martin.clowyer.cases.presenter.CasePresenter
import com.dmd.martin.clowyer.cases.repository.CaseRepositoryImpl

class CaseInteractorImpl(var casePresenter: CasePresenter): CaseInteractor {

    private var caseRepository = CaseRepositoryImpl(casePresenter)
}