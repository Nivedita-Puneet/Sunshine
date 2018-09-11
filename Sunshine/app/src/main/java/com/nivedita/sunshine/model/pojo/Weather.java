
package com.nivedita.sunshine.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "weather")
public class Weather {

    @SerializedName("id")
    @Expose
    @Property(nameInDb = "id")
    private Integer id;

    @Expose
    @SerializedName("weather_id")
    @Id(autoincrement = true)
    private Long weather_id;

    @SerializedName("main")
    @Expose
    @Property(nameInDb = "main")
    private String main;

    @SerializedName("description")
    @Expose
    @Property(nameInDb = "description")
    private String description;

    @SerializedName("icon")
    @Expose
    @Transient
    private String icon;

    @Expose
    @SerializedName("weatherId")
    @Property(nameInDb = "weatherId")
    private Long weatherId;



    @Generated(hash = 45666297)
    public Weather(Integer id, Long weather_id, String main, String description,
            Long weatherId) {
        this.id = id;
        this.weather_id = weather_id;
        this.main = main;
        this.description = description;
        this.weatherId = weatherId;
    }

    @Generated(hash = 556711069)
    public Weather() {
    }



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
