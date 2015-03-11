package com.example.samanthamiller.midterm1;

/**
 * Created by Samantha Miller on 3/11/2015.
 */
public class WeatherInfo {
    private double day;
    private double night;
    private double min;
    private double max;
    private double eve;
    private double morn;
    private String date;
    private int hum;
    private String sky;
    private double press;

    @Override
    public String toString()
    {
        return "Day:  " + day + "\nNight:  " +
                night + "\nDate:  " + date + "\nHum:  " +
                hum;
    }

    public WeatherInfo()
    {

    }

    public WeatherInfo(double day, double night, double min, double max, double eve, double morn, String date, int hum, String sky, double press) {
        this.day = day;
        this.night = night;
        this.min = min;
        this.max = max;
        this.eve = eve;
        this.morn = morn;
        this.date = date;
        this.hum = hum;
        this.sky = sky;
        this.press = press;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public double getPress() {
        return press;
    }

    public void setPress(double press) {
        this.press = press;
    }
}
