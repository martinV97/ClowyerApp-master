package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dmd.martin.clowyer.activities.CaseActivity;
import com.dmd.martin.clowyer.activities.MainActivity;
import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemClient;
import com.dmd.martin.clowyer.entity.ItemDoc;
import com.dmd.martin.clowyer.services.interfaces.ClientInterface;
import com.dmd.martin.clowyer.services.interfaces.DocInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocRest extends AsyncTask<Void, Integer, Void> {

    private AppCompatActivity activity;
    private String numberCase;
    public DocRest(AppCompatActivity activity, String numberCase){
        this.activity = activity;
        this.numberCase = numberCase;
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
        final DocInterface docInterface = builder.create(DocInterface.class);
        Call<List<ItemDoc>> call = docInterface.getListDocs("/document/" + numberCase);
        call.enqueue(new Callback<List<ItemDoc>>() {
            @Override
            public void onResponse(Call<List<ItemDoc>> call, Response<List<ItemDoc>> response) {
                Constants.Companion.setListDocs(response.body());
                Intent intent = new Intent(activity.getBaseContext(), CaseActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }

            @Override
            public void onFailure(Call<List<ItemDoc>> call, Throwable t) {
                Toast.makeText(activity.getBaseContext(), "Error cargando Documentos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
