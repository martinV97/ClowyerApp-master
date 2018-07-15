package com.dmd.martin.clowyer.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ItemDoc {
    @SerializedName("_id")
    @Expose
    private var id: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("caseNumber")
    @Expose
    private var caseNumber: String? = null
    @SerializedName("idLawyer")
    @Expose
    private var idLawyer: String? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null
    @SerializedName("documentName")
    @Expose
    private var documentName: String? = null
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

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getCaseNumber(): String? {
        return caseNumber
    }

    fun setCaseNumber(caseNumber: String) {
        this.caseNumber = caseNumber
    }

    fun getIdLawyer(): String? {
        return idLawyer
    }

    fun setIdLawyer(idLawyer: String) {
        this.idLawyer = idLawyer
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getDocumentName(): String? {
        return documentName
    }

    fun setDocumentName(documentName: String) {
        this.documentName = documentName
    }

    fun getV(): Int? {
        return v
    }

    fun setV(v: Int?) {
        this.v = v
    }
}