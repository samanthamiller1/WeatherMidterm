package com.example.samanthamiller.midterm1;

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
        weather[0] = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/11/15", 0, "Cloudy", 0.0);
        weather[1] = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/12/15", 0, "Rainy", 0.0);
        weather[2] = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/13/15", 0, "Cloudy", 0.0);
        weather[3] = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/14/15", 0, "Sunny", 0.0);
        weather[4]  = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/15/15", 0, "Cloudy", 0.0);
        weather[5]  = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/16/15", 0, "Snowy", 0.0);
        weather[6]  = new WeatherInfo(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "3/17/15", 0, "Snowy", 0.0);

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
