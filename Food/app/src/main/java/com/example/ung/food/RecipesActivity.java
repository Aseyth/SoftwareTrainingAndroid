package com.example.ung.food;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipesActivity extends Activity{

    private Recipe recipe;
    private TextView title;
    private TextView description;
    private ImageView image;
    private TextView products;
    private TextView ingredients;

    private TextView muslimFriendly;
    private TextView healthy;
    private TextView glutenFree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_activity);

        title = (TextView) findViewById(R.id.titleReceipe);
        description = (TextView) findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.imageReceipe);

        ingredients = (TextView) findViewById(R.id.ingredientsLabel);
        products = (TextView) findViewById(R.id.productsLabel);

        muslimFriendly = (TextView) findViewById(R.id.muslimFriendly);
        healthy = (TextView) findViewById(R.id.healthy);
        glutenFree = (TextView) findViewById(R.id.glutenFree);

        recipe = getRecipe();
        if (recipe != null)
        {
            title.setText(recipe.getName());
            description.setText(recipe.getDescription());
            image.setImageBitmap(recipe.getImage());

            if (recipe.getHealthy())
            {
                healthy.setText("Healthy : YES");
                healthy.setTextColor(Color.parseColor("#43A047"));
            }
            else
            {
                healthy.setText("Healthy : NO");
                healthy.setTextColor(Color.parseColor("#F4511E"));
            }

            if (recipe.getGlutenFree())
            {
                glutenFree.setText("GlutenFree : YES");
                glutenFree.setTextColor(Color.parseColor("#43A047"));
            }
            else
            {
                glutenFree.setText("GlutenFree : NO");
                glutenFree.setTextColor(Color.parseColor("#F4511E"));
            }

            if (recipe.getMuslimFriendly())
            {
                muslimFriendly.setText("MuslimFriendly : YES");
                muslimFriendly.setTextColor(Color.parseColor("#43A047"));
            }
            else
            {
                muslimFriendly.setText("MuslimFriendly : NO");
                muslimFriendly.setTextColor(Color.parseColor("#F4511E"));
            }

            products.setText(recipe.getLabelProducts());
            ingredients.setText(recipe.getLabelIngredients());
        }
    }

    public Recipe getRecipe()
    {
        for (int i = 0; i < MainPage.recipeList.size(); i++)
        {
            if (MainPage.recipeList.get(i).getId().equals(getIntent().getStringExtra("recipeID")))
            {
                return MainPage.recipeList.get(i);
            }
        }
        return null;
    }
}
