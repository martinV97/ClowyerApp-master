package com.dmd.martin.clowyer.cardviews.cases.view

import com.dmd.martin.clowyer.entity.ItemCase

interface CaseNavigationView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showCase(case: ItemCase)
    fun showError(error: String)
    fun showSearchError(error: String)
    fun showDeleteError(error: String)
}