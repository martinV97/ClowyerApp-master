package com.dmd.martin.clowyer.login.view

interface LoginView {
    fun enableInputs()
    fun disableInputs()
    fun showProgressBar()
    fun hideProgressBar()
    fun showLoadingText()
    fun hideLoadingText()
    fun loginError(error: String)
    fun showMain()
    fun showRegister()
}