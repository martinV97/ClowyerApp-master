package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.entity.ItemDoc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DocInterface {
    @GET
    Call<List<ItemDoc>> getListDocs(@Url String id);
}
