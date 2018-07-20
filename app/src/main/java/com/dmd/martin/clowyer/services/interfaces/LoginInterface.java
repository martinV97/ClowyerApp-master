package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.entity.ItemLawyer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
    @FormUrlEncoded
    @POST("/login-lawyer")
    Call<ItemLawyer> validateLogin(
            @Field("email") String email,
            @Field("password") String password);

}
