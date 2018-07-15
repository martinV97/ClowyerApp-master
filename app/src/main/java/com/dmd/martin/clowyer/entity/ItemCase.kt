package com.dmd.martin.clowyer.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemCase : Serializable {

    @SerializedName("_id")
    @Expose
    private var id: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("number")
    @Expose
    private var number: String? = null
    @SerializedName("dateStart")
    @Expose
    private var dateStart: String? = null
    @SerializedName("dateFinish")
    @Expose
    private var dateFinish: String? = null
    @SerializedName("courtName")
    @Expose
    private var courtName: String? = null
    @SerializedName("idClient")
    @Expose
    private var idClient: String? = null
    @SerializedName("idLawyer")
    @Expose
    private var idLawyer: String? = null
    @SerializedName("__v")
    @Expose
    private var v: Int? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getNumber(): String? {
        return number
    }

    fun setNumber(number: String) {
        this.number = number
    }

    fun getDateStart(): String? {
        return dateStart
    }

    fun setDateStart(dateStart: String) {
        this.dateStart = dateStart
    }

    fun getDateFinish(): String? {
        return dateFinish
    }

    fun setDateFinish(dateFinish: String) {
        this.dateFinish = dateFinish
    }

    fun getCourtName(): String? {
        return courtName
    }

    fun setCourtName(courtName: String) {
        this.courtName = courtName
    }

    fun getIdClient(): String? {
        return idClient
    }

    fun setIdClient(idClient: String) {
        this.idClient = idClient
    }

    fun getIdLawyer(): String? {
        return idLawyer
    }

    fun setIdLawyer(idLawyer: String) {
        this.idLawyer = idLawyer
    }

    fun getV(): Int? {
        return v
    }

    fun setV(v: Int?) {
        this.v = v
    }

}