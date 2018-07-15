package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemCase;
import com.dmd.martin.clowyer.entity.ItemClient;
import com.dmd.martin.clowyer.entity.ItemCourt;
import com.dmd.martin.clowyer.services.interfaces.ClientInterface;
import com.dmd.martin.clowyer.services.interfaces.CourtInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourtRest extends AsyncTask<Void, Integer, Void> {

    private Context context;
    public CourtRest(Context context){
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
        final CourtInterface courtInterface = builder.create(CourtInterface.class);
        Call<List<ItemCourt>> call = courtInterface.getListCourts();
        call.enqueue(new Callback<List<ItemCourt>>() {
            @Override
            public void onResponse(Call<List<ItemCourt>> call, Response<List<ItemCourt>> response) {
                Constants.Companion.setListCourts(response.body());
            }

            @Override
            public void onFailure(Call<List<ItemCourt>> call, Throwable t) {
                Toast.makeText(context, "Error cargando Clientes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
