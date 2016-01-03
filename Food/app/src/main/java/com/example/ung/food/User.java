package com.example.ung.food;

/**
 * Created by Paulo on 03/01/2016.
 */
public class User {


    enum Type
    {
        CONSUMER,
        GASTRONOMIST,
        SUPPLIER
    };

    private String displayName;
    private Type type;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
