package com.example.ung.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipesActivity extends Activity{

    private TextView Textv;
    private TextView Textv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_activity);

        Textv = (TextView) findViewById(R.id.tv);
        Textv2 = (TextView) findViewById(R.id.tv2);
        Textv.setText(getIntent().getStringExtra("foodName"));
        Textv2.setText(getIntent().getStringExtra("foodDesc"));
    }
}
