package com.dmd.martin.clowyer.services.consumeRest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dmd.martin.clowyer.R;
import com.dmd.martin.clowyer.activities.LoadActivity;
import com.dmd.martin.clowyer.activities.MainActivity;
import com.dmd.martin.clowyer.constants.Constants;
import com.dmd.martin.clowyer.entity.ItemLawyer;
import com.dmd.martin.clowyer.services.interfaces.LoginInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRest extends AsyncTask<Void, Integer, Void> {
    private AppCompatActivity activity;
    private String email, password;
    private ImageView loadImage;
    private ProgressBar progressBar;

    public LoginRest(AppCompatActivity activity, String email, String password, ImageView loadImage, ProgressBar progressBar) {
        this.activity = activity;
        this.email = email;
        this.password = password;
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
        validateLogin(builder);
        return null;
    }

    private void validateLogin(Retrofit builder) {
        final LoginInterface loginInterface = builder.create(LoginInterface.class);
        Call<ItemLawyer> call = loginInterface.validateLogin(email, password);
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
                Toast.makeText(activity, R.string.login_error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
