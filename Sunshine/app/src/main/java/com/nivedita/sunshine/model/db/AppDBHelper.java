package com.nivedita.sunshine.model.db;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Class which defines DAO Operations.
 */

@Singleton
public class AppDBHelper{

    private static final String TAG = AppDBHelper.class.getSimpleName();

    @Inject
    public AppDBHelper(DBOpenHelper dbOpenHelper) {
    }


   /* @Override
    public Flowable<Long> persistSunshine(final Sunshine sunshine) {
       return Flowable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDAOSession.getSunshineDao().insert(sunshine);
            }
        });
    }

    @Override
    public Flowable<List<WeatherList>> getWeatherListDetails(final Sunshine sunshine) {
        return Flowable.fromCallable(new Callable<List<WeatherList>>() {
            @Override
            public List<WeatherList> call() throws Exception {
                return sunshine.getList();
            }
        });
    }

    @Override
    public Flowable<List<Weather>> getWeatherDetails() {
        return Flowable.fromCallable(new Callable<List<Weather>>() {
            @Override
            public List<Weather> call() throws Exception {
                return mDAOSession.getWeatherDao().loadAll();
            }
        });
    }

    @Override
    public Flowable<Weather> getWeather() {
        return null;
    }

    @Override
    public Flowable<Temp> getTemp() {
        return null;
    }*/


}
