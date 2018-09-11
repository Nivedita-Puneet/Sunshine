
package com.nivedita.sunshine.model.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

import java.util.List;

@Entity(nameInDb = "weatherList")
public class WeatherList {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @SerializedName("dt")
    @Expose
    @Property(nameInDb = "Date")
    private Integer dt;

    @NotNull
    private Long tempId;

    @SerializedName("temp")
    @Expose
    @ToOne(joinProperty = "tempId")
    private Temp temp;

    @SerializedName("pressure")
    @Expose
    @Property(nameInDb = "pressure")
    private Float pressure;

    @SerializedName("humidity")
    @Expose
    @Property(nameInDb = "humidity")
    private Integer humidity;

    @SerializedName("weather")
    @Expose
    @ToMany(referencedJoinProperty = "weatherId")
    private java.util.List<Weather> weather = null;

    @SerializedName("speed")
    @Expose
    @Property(nameInDb = "speed")
    private Float speed;

    @SerializedName("deg")
    @Expose
    @Property(nameInDb = "degree")
    private Integer deg;

    @SerializedName("clouds")
    @Expose
    @Property(nameInDb = "clouds")
    private Integer clouds;

    @SerializedName("rain")
    @Expose
    @Property(nameInDb = "rain")
    private Float rain;

    @Expose
    @SerializedName("weatherListId")
    @Property(nameInDb = "weatherListId")
    private Long weatherListId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1086981352)
    private transient WeatherListDao myDao;

    @Generated(hash = 1708176334)
    public WeatherList(Long id, Integer dt, @NotNull Long tempId, Float pressure, Integer humidity,
            Float speed, Integer deg, Integer clouds, Float rain, Long weatherListId) {
        this.id = id;
        this.dt = dt;
        this.tempId = tempId;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
        this.weatherListId = weatherListId;
    }

    @Generated(hash = 1405123287)
    public WeatherList() {
    }

    @Generated(hash = 1970120876)
    private transient Long temp__resolvedKey;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public WeatherList withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1426328977)
    public Temp getTemp() {
        Long __key = this.tempId;
        if (temp__resolvedKey == null || !temp__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TempDao targetDao = daoSession.getTempDao();
            Temp tempNew = targetDao.load(__key);
            synchronized (this) {
                temp = tempNew;
                temp__resolvedKey = __key;
            }
        }
        return temp;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1366316673)
    public void setTemp(@NotNull Temp temp) {
        if (temp == null) {
            throw new DaoException(
                    "To-one property 'tempId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.temp = temp;
            tempId = temp.getId();
            temp__resolvedKey = tempId;
        }
    }

    public WeatherList withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public WeatherList withPressure(Float pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public WeatherList withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 40176618)
    public List<Weather> getWeather() {
        if (weather == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WeatherDao targetDao = daoSession.getWeatherDao();
            List<Weather> weatherNew = targetDao._queryWeatherList_Weather(id);
            synchronized (this) {
                if (weather == null) {
                    weather = weatherNew;
                }
            }
        }
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public WeatherList withWeather(java.util.List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public WeatherList withSpeed(Float speed) {
        this.speed = speed;
        return this;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public WeatherList withDeg(Integer deg) {
        this.deg = deg;
        return this;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public WeatherList withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Float getRain() {
        return rain;
    }

    public void setRain(Float rain) {
        this.rain = rain;
    }

    public WeatherList withRain(Float rain) {
        this.rain = rain;
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

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1453208750)
    public synchronized void resetWeather() {
        weather = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public Long getWeatherListId() {
        return this.weatherListId;
    }

    public void setWeatherListId(Long weatherListId) {
        this.weatherListId = weatherListId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 363406127)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeatherListDao() : null;
    }

}
