package com.example.ung.food;

import android.media.Image;

/**
 * Created by Paulo on 03/01/2016.
 */
public class Recipe {

    private String name;
    private String description;
    private Boolean glutenFree;
    private Boolean healthy;
    private Boolean muslimFriendly;
    private Image image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getHealthy() {
        return healthy;
    }

    public void setHealthy(Boolean healthy) {
        this.healthy = healthy;
    }

    public Boolean getMuslimFriendly() {
        return muslimFriendly;
    }

    public void setMuslimFriendly(Boolean muslimFriendly) {
        this.muslimFriendly = muslimFriendly;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
