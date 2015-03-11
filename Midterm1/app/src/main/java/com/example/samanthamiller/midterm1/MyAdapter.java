package com.example.samanthamiller.midterm1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Samantha Miller on 3/11/2015.
 */
public class MyAdapter extends BaseAdapter {
    WeatherInfo [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public MyAdapter(MainActivity mainActivity, WeatherInfo[] weather, int[] images) {
        // TODO Auto-generated constructor stub
        result=weather;
        context=mainActivity;
        imageId=images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.weatherinfo, null);
        holder.tv=(TextView) rowView.findViewById(R.id.Weather);
        holder.img=(ImageView) rowView.findViewById(R.id.icon);
        holder.tv.setText(result[position].toString());
        holder.img.setImageResource(imageId[position]);
        Button details = (Button) rowView.findViewById(R.id.Details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String toString = result[position].toString() + "\nMin:  " + result[position].getMin() +
                        "\nMax:  " + result[position].getMax() + "\nEvening:  " +
                        result[position].getEve() + "\nMorning:  " + result[position].getMorn() +
                        "\nPressure:  " + result[position].getPress();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("details", toString);
                context.startActivity(intent);
            }
        });
        return rowView;
    }
}