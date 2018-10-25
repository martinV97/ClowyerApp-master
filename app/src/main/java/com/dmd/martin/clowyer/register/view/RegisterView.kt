package com.dmd.martin.clowyer.register.view

interface RegisterView {
    fun enableInputs()
    fun disableInputs()
    fun showProgressBar()
    fun hideProgressBar()
    fun registerError(error: String)
    fun showMain()
    fun showLogin()
}