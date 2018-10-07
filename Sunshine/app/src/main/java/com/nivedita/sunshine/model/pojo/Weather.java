
package com.nivedita.sunshine.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weather {

    @SerializedName("id")
    @Expose
    private Integer id;

    @Expose
    @SerializedName("weather_id")
    private Long weather_id;

    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("icon")
    @Expose
    private String icon;

    @Expose
    @SerializedName("weatherId")
    private Long weatherId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Weather withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Weather withMain(String main) {
        this.main = main;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Weather withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Weather withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Long getWeather_id() {
        return this.weather_id;
    }

    public void setWeather_id(Long weather_id) {
        this.weather_id = weather_id;
    }

    public Long getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
    }

}
