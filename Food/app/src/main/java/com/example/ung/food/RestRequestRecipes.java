package com.example.ung.food;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.net.CookieManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paulo on 02/01/2016.
 */
public class RestRequestRecipes extends AsyncTask<String, Void, Boolean> {


    private OnTaskCompleted listener;
    private String url = "http://54.169.96.145:3000";

    public RestRequestRecipes(OnTaskCompleted listener)
    {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... arg) {

        try {
            getAllRecipes();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        listener.onAllReceipesReceived();
    }

    public boolean getAllRecipes() throws JSONException {

        HttpRequest request = HttpRequest.get(url + "/android/recipes");
        String json = request.body();

        JsonParser jsonParser = new JsonParser(new JSONArray(json));
        MainPage.recipeList = jsonParser.getAllRecipes();


        for (int i = 0; i < MainPage.recipeList.size(); i++)
        {
            System.out.println("NAME RECIPE :");
            System.out.println(MainPage.recipeList.get(i).getName());
        }

        return true;
    }
}
