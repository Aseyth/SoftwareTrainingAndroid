package com.example.ung.food;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipesActivity extends Activity{

    private Recipe recipe;
    private TextView title;
    private TextView description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_activity);

        title = (TextView) findViewById(R.id.titleReceipe);
        description = (TextView) findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.imageReceipe);

        recipe = getRecipe();
        if (recipe != null)
        {
            title.setText(recipe.getName());
            description.setText(recipe.getDescription());
            image.setImageBitmap(recipe.getImage());
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
