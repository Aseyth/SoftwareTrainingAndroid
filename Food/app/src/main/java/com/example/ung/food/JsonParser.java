package com.example.ung.food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulo on 03/01/2016.
 */
public class JsonParser {

    private JSONArray jRecipe;

    JsonParser(JSONArray jsonArray)
    {
        jRecipe = jsonArray;
    }

    public List<Recipe> getAllRecipes() throws JSONException {

        List<Recipe> listRecipe = new ArrayList<Recipe>();

        for (int i = 0; i < jRecipe.length(); i++)
        {
            JSONObject c = jRecipe.getJSONObject(i);
            Recipe tmpRecipe = new Recipe();
            tmpRecipe.setName(c.getString("name"));
            listRecipe.add(tmpRecipe);
        }

        return listRecipe;
    }
}
