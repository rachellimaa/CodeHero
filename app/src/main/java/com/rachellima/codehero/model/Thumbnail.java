package com.rachellima.codehero.model;

import com.google.gson.annotations.SerializedName;

public class Thumbnail {
    @SerializedName("path")
    private String pathImage;

    @SerializedName("extension")
    private String extensionImage;

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getExtensionImage() {
        return extensionImage;
    }

    public void setExtensionImage(String extensionImage) {
        this.extensionImage = extensionImage;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "pathImage='" + pathImage + '\'' +
                ", extensionImage='" + extensionImage + '\'' +
                '}';
    }
}
