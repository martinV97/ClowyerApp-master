package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemCase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CaseInterface {
    @GET
    Call<List<ItemCase>> getListCases(@Url String id);
}
