package com.dmd.martin.clowyer.navigation.interactor

import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenter
import com.dmd.martin.clowyer.navigation.repository.NavigationRepositoryImpl

class NavigationInteractorImpl(var navigationPresenter: NavigationPresenter): NavigationInteractor {

    private var caseRepository = NavigationRepositoryImpl(navigationPresenter)
}