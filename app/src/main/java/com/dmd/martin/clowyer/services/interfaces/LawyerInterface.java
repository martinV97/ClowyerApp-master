package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.entity.ItemLawyer;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface LawyerInterface {
    @Multipart
    @POST("/lawyer")
    Call<ItemLawyer> registerLawyer(
            @Part("identification") String identification,
            @Part("name") String name,
            @Part("speciality") String speciality,
            @Part("phone") String phone,
            @Part("email") String email,
            @Part("password") String password,
            @Part MultipartBody.Part img);
}
