package com.nivedita.sunshine.model.db;

import android.util.Log;

import com.nivedita.sunshine.model.pojo.DaoMaster;
import com.nivedita.sunshine.model.pojo.DaoSession;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.pojo.Temp;
import com.nivedita.sunshine.model.pojo.Weather;
import com.nivedita.sunshine.model.pojo.WeatherList;

import org.greenrobot.greendao.internal.DaoConfig;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Class which defines DAO Operations.
 */

@Singleton
public class AppDBHelper implements DBHelper {

    private final DaoSession mDAOSession;
    private static final String TAG = AppDBHelper.class.getSimpleName();

    @Inject
    public AppDBHelper(DBOpenHelper dbOpenHelper) {
        mDAOSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
        Log.i(TAG, "The session is" + mDAOSession.getSunshineDao());
    }


    @Override
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
    }


}
