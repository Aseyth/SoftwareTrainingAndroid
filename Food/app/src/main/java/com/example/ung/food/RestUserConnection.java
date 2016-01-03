package com.example.ung.food;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieManager;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paulo on 02/01/2016.
 */
public class RestUserConnection extends AsyncTask<String, Void, Boolean>  {

    private OnTaskCompleted listener;

    private Boolean isConnected = false;

//private String url  = "localhost:3000";
   private String url = "http://54.169.96.145:3000";

    public RestUserConnection (OnTaskCompleted listener)
    {
        this.listener = listener;
    }

    public RestUserConnection() {

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }



    @Override
    protected Boolean doInBackground(String... arg) {

        try {
            return(connectUser(arg[0], arg[1]));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        // send bool
        listener.onTryLoggin(isConnected);
    }

    public boolean connectUser(String username, String password) throws JSONException {


        Map<String, String> data = new HashMap<String, String>();

        try {
            data.put("username", username);
            data.put("password", password);
            HttpRequest request = HttpRequest.post(url + "/auth/signin").form(data);
            String json = request.body();

            System.out.println(json);
            JsonParser jsonParser = new JsonParser(new JSONObject(json));

            isConnected = jsonParser.checkConnection();

            return true;
        } catch (HttpRequest.HttpRequestException exception) {
            return false;
        }

    }
}
