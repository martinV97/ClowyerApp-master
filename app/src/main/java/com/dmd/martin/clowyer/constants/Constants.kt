package com.dmd.martin.clowyer.constants

import com.dmd.martin.clowyer.entity.*

class Constants {
    companion object {
        val REST_URL ="https://clowyer.herokuapp.com"
        var lawyer: ItemLawyer? = null
        var listCases: MutableList<ItemCase> = arrayListOf()
        var listClients: MutableList<ItemClient> = arrayListOf()
        var listCourts: MutableList<ItemCourt> = arrayListOf()
        var listDocs: MutableList<ItemDoc> = arrayListOf()
        val PICK_IMAGE = 1
    }
}