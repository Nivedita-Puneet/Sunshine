package com.nivedita.sunshine.model;

import android.content.Context;
import android.util.Log;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.model.db.DBHelper;
import com.nivedita.sunshine.model.network.Apihelper;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.pojo.Temp;
import com.nivedita.sunshine.model.pojo.Weather;
import com.nivedita.sunshine.model.pojo.WeatherList;
import com.nivedita.sunshine.model.prefs.PrefsHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Class used to handle data intense operations.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = AppDataManager.class.getSimpleName();

    private final Context context;
    private final PrefsHelper prefsHelper;
    private final Apihelper apihelper;
    private final DBHelper dbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PrefsHelper prefsHelper, Apihelper apihelper, DBHelper dbHelper) {

        this.context = context;
        this.prefsHelper = prefsHelper;
        this.apihelper = apihelper;
        this.dbHelper = dbHelper;
    }


    public String getLocationDetails() {
        String locationDetails = prefsHelper.getLocationDetails();
        Log.i(TAG, "The location details obtained are" + locationDetails);
        return locationDetails;
    }


    public void setLocationDetails(String place) {
        prefsHelper.setLocationDetails(place);
    }

    public Flowable<Sunshine> getDailyWeatherReports(String place) {
        // Log.i(TAG, location);
        return apihelper.getDailyWeatherReports(place);
    }

    public void startSunshineActivity() {

    }

    @Override
    public void onPageLoad() {

    }

    @Override
    public Flowable<Long> persistSunshine(Sunshine sunshine) {
        return dbHelper.persistSunshine(sunshine);
    }

    @Override
    public Flowable<List<WeatherList>> getWeatherListDetails(Sunshine sunshine) {
        return dbHelper.getWeatherListDetails(sunshine);
    }

    @Override
    public Flowable<List<Weather>> getWeatherDetails() {
        return dbHelper.getWeatherDetails();
    }

    @Override
    public Flowable<Weather> getWeather() {
        return dbHelper.getWeather();
    }

    @Override
    public Flowable<Temp> getTemp() {
        return dbHelper.getTemp();
    }
}
