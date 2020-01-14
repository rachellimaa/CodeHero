package com.rachellima.codehero.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class Hero {
    @SerializedName("id")
    private int HeroId;

    @SerializedName("name")
    private String HeroName;

   /* @SerializedName("thumbnail")
    private String HeroImage;*/

    public int getHeroId() {
        return HeroId;
    }

    public void setHeroId(int heroId) {
        HeroId = heroId;
    }

    public String getHeroName() {
        return HeroName;
    }

    public void setHeroName(String heroName) {
        HeroName = heroName;
    }


}
