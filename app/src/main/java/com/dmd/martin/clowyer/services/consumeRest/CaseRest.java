package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dmd.martin.clowyer.activities.MainActivity;
import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemCase;
import com.dmd.martin.clowyer.services.interfaces.CaseInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CaseRest  extends AsyncTask<Void, Integer, Void> {
    private AppCompatActivity activity;

    public CaseRest(AppCompatActivity activity){
        this.activity = activity;
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
        final CaseInterface clientInterface = builder.create(CaseInterface.class);
        Call<List<ItemCase>> call = clientInterface.getListCases("/case/"+ Constants.Companion.getLawyer().getId());
        call.enqueue(new Callback<List<ItemCase>>() {
            @Override
            public void onResponse(Call<List<ItemCase>> call, Response<List<ItemCase>> response) {
                Constants.Companion.setListCases(response.body());
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }

            @Override
            public void onFailure(Call<List<ItemCase>> call, Throwable t) {
                Toast.makeText(activity, "Error cargando Casos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
