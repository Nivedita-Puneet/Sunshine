
package com.nivedita.sunshine.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sunshine {

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Float message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<WeatherList> list = null;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Sunshine withCity(City city) {
        this.city = city;
        return this;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Sunshine withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public Sunshine withMessage(Float message) {
        this.message = message;
        return this;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Sunshine withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    public java.util.List<WeatherList> getList() {
        return list;
    }

    public void setList(java.util.List<WeatherList> list) {
        this.list = list;
    }

    public Sunshine withList(java.util.List<WeatherList> list) {
        this.list = list;
        return this;
    }

}
