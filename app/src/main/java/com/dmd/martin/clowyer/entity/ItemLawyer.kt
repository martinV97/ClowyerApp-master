package com.dmd.martin.clowyer.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ItemLawyer {
    @SerializedName("_id")
    @Expose
    private var id: String? = null
    @SerializedName("identification")
    @Expose
    private var identification: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("speciality")
    @Expose
    private var speciality: String? = null
    @SerializedName("phone")
    @Expose
    private var phone: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("email")
    @Expose
    private var email: String? = null
    @SerializedName("password")
    @Expose
    private var password: String? = null
    @SerializedName("avatar")
    @Expose
    private var avatar: String? = null
    @SerializedName("imgName")
    @Expose
    private var imgName: String? = null
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

    fun getSpeciality(): String? {
        return speciality
    }

    fun setSpeciality(speciality: String) {
        this.speciality = speciality
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getAvatar(): String? {
        return avatar
    }

    fun setAvatar(avatar: String) {
        this.avatar = avatar
    }

    fun getImgName(): String? {
        return imgName
    }

    fun setImgName(imgName: String) {
        this.imgName = imgName
    }

    fun getV(): Int? {
        return v
    }

    fun setV(v: Int?) {
        this.v = v
    }
}