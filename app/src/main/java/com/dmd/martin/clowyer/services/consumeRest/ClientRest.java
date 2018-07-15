package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemClient;
import com.dmd.martin.clowyer.services.interfaces.ClientInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRest extends AsyncTask<Void, Integer, Void> {

    private Context context;
    public ClientRest(Context context){
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(Constants.Companion.getREST_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient().newBuilder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build())
                .build();
        loadCases(builder);
        return null;
    }

    private void loadCases(Retrofit builder) {
        final ClientInterface clientInterface = builder.create(ClientInterface.class);
        Call<List<ItemClient>> call = clientInterface.getListClients("/client/" + Constants.Companion.getLawyer().getId());
        call.enqueue(new Callback<List<ItemClient>>() {
            @Override
            public void onResponse(Call<List<ItemClient>> call, Response<List<ItemClient>> response) {
                Constants.Companion.setListClients(response.body());
            }

            @Override
            public void onFailure(Call<List<ItemClient>> call, Throwable t) {
                Toast.makeText(context, "Error cargando Clientes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
