package com.rachellima.codehero.apicodehero;

import android.util.Log;

import androidx.annotation.NonNull;

import com.rachellima.codehero.BuildConfig;
import com.rachellima.codehero.apicodehero.service.IHero;
import com.rachellima.codehero.events.ResultDataEvent;
import com.rachellima.codehero.model.Data;
import com.rachellima.codehero.model.ResponseHero;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIClientCodeHero {
    private static final String TAG = "APIClientCodeHero";

    private IHero mService;

    public APIClientCodeHero(IHero service) {
        this.mService = service;
    }

    public void getHeroList(String name, int limit, int offset, String timestamp, String hash) {
        Call<ResponseHero> responseCall = mService.getHeroList(name, limit, offset, timestamp, BuildConfig.API_PUBLIC_KEY, hash);
        responseCall.enqueue(new Callback<ResponseHero>() {
            @Override
            public void onResponse(@NonNull Call<ResponseHero> call, @NonNull Response<ResponseHero> response) {
                if (response.isSuccessful()) {
                    ResponseHero responseHero = response.body();
                    Data data = responseHero.getData();

                    EventBus.getDefault().post(new ResultDataEvent(data));
                    Log.d(TAG, "data " + data);
                } else {
                    Log.e(TAG, "onResponse " + response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseHero> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure " + t);
            }
        });
    }

    public void getHeroListAll(String timestamp, String hash) {
        Call<ResponseHero> responseHeroCall = mService.getHeroListAll(timestamp, BuildConfig.API_PUBLIC_KEY, hash);
        responseHeroCall.enqueue(new Callback<ResponseHero>() {
            @Override
            public void onResponse(Call<ResponseHero> call, Response<ResponseHero> response) {
                if (response.isSuccessful()) {
                    ResponseHero responseHero = response.body();
                    Data data = responseHero.getData();

                    EventBus.getDefault().post(new ResultDataEvent(data));
                    Log.d(TAG, "data " + data);
                } else {
                    Log.e(TAG, "onResponse " + response);
                }
            }

            @Override
            public void onFailure(Call<ResponseHero> call, Throwable t) {
                Log.e(TAG, "onFailure " + t);
            }
        });
    }

}
