package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dmd.martin.clowyer.activities.LoadActivity;
import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemLawyer;
import com.dmd.martin.clowyer.services.interfaces.LawyerInterface;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterRest extends AsyncTask<Void, Integer, Void> {
    private AppCompatActivity activity;
    private ItemLawyer lawyer;
    private ImageView loadImage;
    private ProgressBar progressBar;
    private Intent data;

    public RegisterRest(AppCompatActivity activity, ItemLawyer lawyer, Intent data, ImageView loadImage, ProgressBar progressBar) {
        this.activity = activity;
        this.lawyer = lawyer;
        this.loadImage = loadImage;
        this.progressBar = progressBar;
        this.data = data;
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
        final LawyerInterface lawyerInterface = builder.create(LawyerInterface.class);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), data.getData().getEncodedPath());
        MultipartBody.Part body = MultipartBody.Part.createFormData("img", "img", requestFile);
        Call<ItemLawyer> call = lawyerInterface.registerLawyer(lawyer.getIdentification(), lawyer.getName(), lawyer.getSpeciality(), lawyer.getPhone(), lawyer.getEmail(), lawyer.getPassword(), body);
        call.enqueue(new Callback<ItemLawyer>() {
            @Override
            public void onResponse(Call<ItemLawyer> call, Response<ItemLawyer> response) {
                loadImage.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Constants.Companion.setLawyer(response.body());
                Intent intent = new Intent(activity, LoadActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }

            @Override
            public void onFailure(Call<ItemLawyer> call, Throwable t) {
                loadImage.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(activity, "kkkkkkk" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
