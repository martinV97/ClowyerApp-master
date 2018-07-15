package com.dmd.martin.clowyer.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemClient : Serializable {

    @SerializedName("_id")
    @Expose
    private var id: String? = null
    @SerializedName("identification")
    @Expose
    private var identification: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("date")
    @Expose
    private var date: String? = null
    @SerializedName("phone")
    @Expose
    private var phone: String? = null
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

    fun getIdentification(): String? {
        return identification
    }

    fun setIdentification(identification: String) {
        this.identification = identification
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String) {
        this.phone = phone
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