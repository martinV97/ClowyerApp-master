package com.dmd.martin.clowyer.cardviews.cases.view

interface CaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun searchError(error: String)
    fun deleteError(error: String)
    fun showCase()
}