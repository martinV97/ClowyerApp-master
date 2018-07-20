package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dmd.martin.clowyer.R;
import com.dmd.martin.clowyer.activities.CaseActivity;
import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemDoc;
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
    private ImageView loadImage;
    private ProgressBar progressBar;

    public DocRest(AppCompatActivity activity, String numberCase, ImageView loadImage, ProgressBar progressBar){
        this.activity = activity;
        this.numberCase = numberCase;
        this.loadImage = loadImage;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        loadImage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<List<ItemDoc>> call, Response<List<ItemDoc>> response) {
                Constants.Companion.setListDocs(response.body());
                loadImage.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(activity.getBaseContext(), CaseActivity.class);
                activity.startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<ItemDoc>> call, Throwable t) {
                loadImage.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(activity.getBaseContext(), R.string.error_loading_docs, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
