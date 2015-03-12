package com.example.samanthamiller.midterm1;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private static WeatherInfo[] weather = new WeatherInfo[7];
    private static int[] images = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText search = (EditText) findViewById(R.id.search);

        final Button searchButton = (Button)findViewById(R.id.srchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listView(search.getText().toString());
            }
        });
    }

    private void listView(String text)
    {
        AsyncTask<String, Void, String> as = new Forecast().execute(text);
        String json = null;
        try
        {
            json = as.get();
        }
        catch(Exception e)
        {

        }
        System.out.println(json);

        weather[0] = new WeatherInfo(44.0, 28.0, 42.3, 30.1, 32.6, 27.4, "3/11/15", 0, "Cloudy", 30.1);
        weather[1] = new WeatherInfo(42.7, 30.6, 39.9, 30.0, 31.4, 25.0, "3/12/15", 80, "Rainy", 29.8);
        weather[2] = new WeatherInfo(45.8, 31.9, 44.6, 33.2, 35.7, 32.3, "3/13/15", 80, "Cloudy", 32.9);
        weather[3] = new WeatherInfo(35.5, 33.2, 35.0, 32.7, 33.0, 33.0, "3/14/15", 100, "Sunny", 35.0);
        weather[4]  = new WeatherInfo(32.1, 26.3, 31.8, 27.4, 29.4, 31.4, "3/15/15", 70, "Cloudy", 29.1);
        weather[5]  = new WeatherInfo(29.4, 20.0, 26.1, 28.7, 27.7, 30.8, "3/16/15", 20, "Snowy", 28.2);
        weather[6]  = new WeatherInfo(30.2, 25.2, 31.1, 26.6, 30.0, 29.3, "3/17/15", 10, "Snowy", 33.8); //Summer time!

        for(int i = 0; i < 7; i++)
        {
            WeatherInfo obj = weather[i];

            weather[i] = obj;
            if(obj.getSky().equals("Cloudy"))
                images[i] = R.drawable.cloudy;
            else if(obj.getSky().equals("Clear"))
                images[i] = R.drawable.sunny;
            else if(obj.getSky().equals("Rainy"))
                images[i] = R.drawable.rainy;
            else if(obj.getSky().equals("Snowy"))
                images[i] = R.drawable.snowy;
        }

        ListView list = (ListView)findViewById(R.id.listView);

        list.setAdapter(new MyAdapter(this, weather, images));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
