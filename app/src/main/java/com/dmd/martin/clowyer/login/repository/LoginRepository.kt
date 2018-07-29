package com.dmd.martin.clowyer.login.repository

interface LoginRepository {
    fun signIn(email: String, password: String)
}