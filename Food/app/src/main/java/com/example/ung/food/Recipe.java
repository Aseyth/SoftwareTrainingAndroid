package com.example.ung.food;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Paulo on 03/01/2016.
 */
public class Recipe {

    private String id;
    private String name;
    private String description;
    private Boolean glutenFree;
    private Boolean healthy;
    private Boolean muslimFriendly;
    private Bitmap image;

    private List<Product> products;
    private List<Ingredient> ingredients;

    Recipe()
    {
        products = new ArrayList<Product>();
        ingredients = new ArrayList<Ingredient>();
    }

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

    public void addIngredients(List<Ingredient> _ingredients) { ingredients = _ingredients; }

    public void addProducts(List<Product> _products) { products = _products; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getLabelProducts()
    {
        String label = "";

        for (int i = 0; i < products.size(); i++)
        {
            label += products.get(i).getName() + "\n";
        }
        return label;
    }

    public String getLabelIngredients()
    {
        String label = "";

        for (int i = 0; i < ingredients.size(); i++)
        {
            label += ingredients.get(i).getName() + "\n";
        }
        return label;
    }
}
