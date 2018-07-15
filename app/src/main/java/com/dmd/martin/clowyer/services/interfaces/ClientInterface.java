package com.dmd.martin.clowyer.services.interfaces;

import com.dmd.martin.clowyer.entity.ItemClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ClientInterface {
    @GET
    Call<List<ItemClient>> getListClients(@Url String id);
}
