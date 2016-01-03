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

    // RECIPE

    private static final String RECIPE_NAME = "name"; // String
    private static final String RECIPE_ID = "_id"; // String
    private static final String RECIPE_DESCRIPTION = "description"; // String
    private static final String GLUTEN_FREE = "glutenFree"; // Boolean
    private static final String HEALTHY = "healthy"; // Boolean
    private static final String MUSLIM_FRIENDLY = "muslimFrienfly"; // Boolean

    // PRODUCT

    private static final String PRODUCTS = "products"; // string
    private static final String PRODUCT_NAME = "name"; // String

    // INGREDIENT

    private static final String INGREDIENTS = "ingredients"; // String
    private static final String INGREDIENT_NAME = "name"; // String

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
            listRecipe.add(generateRecipe(c));
        }

        return listRecipe;
    }

    public Recipe generateRecipe(JSONObject c) throws JSONException {
        Recipe tmpRecipe = new Recipe();
        tmpRecipe.setId(c.getString(RECIPE_ID));
        tmpRecipe.setName(c.getString(RECIPE_NAME));
        tmpRecipe.setDescription(c.getString(RECIPE_DESCRIPTION));
        tmpRecipe.setGlutenFree(c.getBoolean(GLUTEN_FREE));
        tmpRecipe.setHealthy(c.getBoolean(HEALTHY));
        tmpRecipe.setMuslimFriendly(c.getBoolean(MUSLIM_FRIENDLY));
        
        tmpRecipe.addProducts(generateProducts(c.getJSONArray(PRODUCTS)));
        tmpRecipe.addIngredients(generateIngredients(c.getJSONArray(INGREDIENTS)));

        return tmpRecipe;
    }

    public List<Product> generateProducts(JSONArray productsJSON) throws JSONException {
        List<Product> products = new ArrayList<Product>();

        for (int i = 0; i < productsJSON.length(); i++)
        {
            Product product = new Product();
            JSONObject c = productsJSON.getJSONObject(i);

            product.setName(c.getString(PRODUCT_NAME));
            products.add(product);
        }

        return products;
    }

    public List<Ingredient> generateIngredients(JSONArray ingredientsJSON) throws JSONException {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        for (int i = 0; i < ingredientsJSON.length(); i++)
        {
            Ingredient ingredient = new Ingredient();
            JSONObject c = ingredientsJSON.getJSONObject(i);

            ingredient.setName(c.getString(INGREDIENT_NAME));
            ingredients.add(ingredient);
        }
        return ingredients;
    }
}
