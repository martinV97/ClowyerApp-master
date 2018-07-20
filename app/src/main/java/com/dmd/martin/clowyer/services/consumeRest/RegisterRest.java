package com.dmd.martin.clowyer.services.consumeRest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemLawyer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterRest extends AsyncTask<Void, Integer, Void> {
    private AppCompatActivity activity;
    private ItemLawyer lawyer;
    private ImageView loadImage;
    private ProgressBar progressBar;

    public RegisterRest(AppCompatActivity activity, ItemLawyer lawyer, ImageView loadImage, ProgressBar progressBar) {
        this.activity = activity;
        this.lawyer = lawyer;
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
        registerLawyer(builder);
        return null;
    }

    private void registerLawyer(Retrofit builder) {

    }
}
