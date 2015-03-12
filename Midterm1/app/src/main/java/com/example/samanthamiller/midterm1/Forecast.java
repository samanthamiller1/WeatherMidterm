package com.example.samanthamiller.midterm1;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.InputStream;

/**
 * Created by Samantha Miller on 3/11/2015.
 */
public class Forecast extends AsyncTask<String, Void, String>
{
    public Forecast(){

    }
    protected String doInBackground(String... stuff){
        StringBuilder sb = new StringBuilder();
        try{
            String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+stuff[0]+"&mode=json&units=metric&cnt=7";

            HttpClient httpclient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpGet, localContext);

            InputStream in = response.getEntity().getContent();
            int x = in.read();
            while(x != -1)
            {
                sb.append((char)x);
                x = in.read();
            }
        }
        catch(Exception e){


        }
        return sb.toString();
    }
}
