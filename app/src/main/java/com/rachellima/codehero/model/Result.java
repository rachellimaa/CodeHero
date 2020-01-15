package com.rachellima.codehero.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    private int idHero;

    @SerializedName("name")
    private String nameHero;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getNameHero() {
        return nameHero;
    }

    public void setNameHero(String nameHero) {
        this.nameHero = nameHero;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Result{" +
                "idHero=" + idHero +
                ", nameHero=" + nameHero +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
