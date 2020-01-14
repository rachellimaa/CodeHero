package com.rachellima.codehero.apicodehero;

import android.util.Log;

import androidx.annotation.NonNull;

import com.rachellima.codehero.BuildConfig;
import com.rachellima.codehero.apicodehero.service.IHero;
import com.rachellima.codehero.events.HeroListEvent;
import com.rachellima.codehero.model.Hero;
import com.rachellima.codehero.model.HeroList;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.ResponseBody;
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
        Call<HeroList> heroList = mService.getHeroList(name, limit, offset, timestamp, BuildConfig.API_PUBLIC_KEY, hash);
        heroList.enqueue(new Callback<HeroList>() {
            @Override
            public void onResponse(@NonNull Call<HeroList> call, @NonNull Response<HeroList> response) {
                if (response.isSuccessful()) {
                    HeroList heroList = response.body();
                    List<Hero> heroes = heroList.getHeroesList();

                    EventBus.getDefault().post(new HeroListEvent(heroes));
                    Log.d(TAG, "repository " + heroes);
                } else {
                    ResponseBody responseBody = response.errorBody();
                    Log.d(TAG, "error " + responseBody);
                }
            }

            @Override
            public void onFailure(@NonNull Call<HeroList> call, @NonNull Throwable t) {
                Log.e(TAG, "error " + t);
            }
        });
    }

}
