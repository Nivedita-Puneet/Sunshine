package com.nivedita.weatherutility.model;

/*Object which holds all the weather details to be displayed.*/
public class Weatherattrs {

    private double minTemp;
    private double maxTemp;
    private String weatherDesc;
    private long date;

    public Weatherattrs(long date, double minTemp, double maxTemp, String weatherDesc) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.weatherDesc = weatherDesc;
    }


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }


}
