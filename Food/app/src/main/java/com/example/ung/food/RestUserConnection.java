package com.example.ung.food;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import java.net.CookieManager;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paulo on 02/01/2016.
 */
public class RestUserConnection extends AsyncTask<String, Void, Boolean>  {

//private String url  = "localhost:3000";
   private String url = "http://54.169.96.145:3000";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }



    @Override
    protected Boolean doInBackground(String... arg) {

        return(connectUser());

    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

    }

    public boolean connectUser()
    {


        Map<String, String> data = new HashMap<String, String>();

        try {
            data.put("username", "test");
            data.put("password", "testtest");
            HttpRequest request = HttpRequest.post(url + "/auth/signin").form(data);

            return true;
        } catch (HttpRequest.HttpRequestException exception) {
            return false;
        }

    }
}
