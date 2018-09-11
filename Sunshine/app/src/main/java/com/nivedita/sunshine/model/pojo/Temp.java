
package com.nivedita.sunshine.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import dagger.Provides;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "temp")
public class Temp {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;


    @SerializedName("day")
    @Expose
    @Property(nameInDb = "day")
    private Float day;

    @SerializedName("min")
    @Expose
    @Property(nameInDb = "min_temp")
    private Float min;

    @SerializedName("max")
    @Expose
    @Property(nameInDb = "max_temp")
    private Float max;

    @SerializedName("night")
    @Expose
    @Property(nameInDb = "night_temp")
    private Float night;

    @SerializedName("eve")
    @Expose
    @Property(nameInDb = "eve_temp")
    private Float eve;

    @SerializedName("morn")
    @Expose
    @Property(nameInDb = "morn")
    private Float morn;

    @Expose
    @SerializedName("tempId")
    @Property(nameInDb = "tempId")
    private Long tempId;


    @Generated(hash = 1709675106)
    public Temp(Long id, Float day, Float min, Float max, Float night, Float eve,
            Float morn, Long tempId) {
        this.id = id;
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
        this.tempId = tempId;
    }

    @Generated(hash = 1524106993)
    public Temp() {
    }


    public Float getDay() {
        return day;
    }

    public void setDay(Float day) {
        this.day = day;
    }

    public Temp withDay(Float day) {
        this.day = day;
        return this;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Temp withMin(Float min) {
        this.min = min;
        return this;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Temp withMax(Float max) {
        this.max = max;
        return this;
    }

    public Float getNight() {
        return night;
    }

    public void setNight(Float night) {
        this.night = night;
    }

    public Temp withNight(Float night) {
        this.night = night;
        return this;
    }

    public Float getEve() {
        return eve;
    }

    public void setEve(Float eve) {
        this.eve = eve;
    }

    public Temp withEve(Float eve) {
        this.eve = eve;
        return this;
    }

    public Float getMorn() {
        return morn;
    }

    public void setMorn(Float morn) {
        this.morn = morn;
    }

    public Temp withMorn(Float morn) {
        this.morn = morn;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTempId() {
        return this.tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

}
