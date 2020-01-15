package com.rachellima.codehero.apicodehero.service;

import com.rachellima.codehero.model.ResponseHero;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IHero {

    @GET("characters?")
    Call<ResponseHero> getHeroList(@Query("name") String name,
                                   @Query("limit") int limit,
                                   @Query("offset") int offset,
                                   @Query("ts") String ts,
                                   @Query("apikey") String apiKey,
                                   @Query("hash") String hash);


    @GET("characters?")
    Call<ResponseHero> getHeroListAll(@Query("ts") String ts,
                                      @Query("apikey") String apiKey,
                                      @Query("hash") String hash);

}
