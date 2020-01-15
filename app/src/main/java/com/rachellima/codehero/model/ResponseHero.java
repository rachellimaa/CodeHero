package com.rachellima.codehero.model;

import com.google.gson.annotations.SerializedName;

public class ResponseHero {
    @SerializedName("data")
    Data Data;

    public Data getData() {
        return Data;
    }

    @Override
    public String toString() {
        return "ResponseHero{" +
                "Data=" + Data +
                '}';
    }
}
