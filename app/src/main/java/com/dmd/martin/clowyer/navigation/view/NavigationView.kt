package com.dmd.martin.clowyer.navigation.view

import com.dmd.martin.clowyer.entity.ItemCase
import com.dmd.martin.clowyer.entity.ItemClient
import com.dmd.martin.clowyer.entity.ItemCourt

interface NavigationView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showCase(case: ItemCase)
    fun showClient(client: ItemClient)
    fun showCourt(court: ItemCourt)
    fun showError(error: String)
    fun showSearchError(error: String)
    fun showDeleteError(error: String)
}