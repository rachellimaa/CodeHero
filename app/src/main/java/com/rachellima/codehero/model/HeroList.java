package com.rachellima.codehero.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroList {
    private List<Hero> HeroesList;

    public List<Hero> getHeroesList() {
        return HeroesList;
    }

    public void setHeroesList(List<Hero> heroesList) {
        HeroesList = heroesList;
    }
}
