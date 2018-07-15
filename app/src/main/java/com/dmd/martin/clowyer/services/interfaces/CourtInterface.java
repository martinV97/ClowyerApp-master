package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.entity.ItemCourt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourtInterface {
    @GET("/court")
    Call<List<ItemCourt>> getListCourts();
}
