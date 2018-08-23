package com.nivedita.sunshine.model;

import android.content.SharedPreferences;

import com.nivedita.sunshine.model.network.Apihelper;
import com.nivedita.sunshine.model.network.SunshineService;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.prefs.PrefsHelper;
import com.nivedita.sunshine.utility.ConstantsUtil;


/**
 * Interface which defines all data related operations of application.
 */

public interface DataManager extends Apihelper, PrefsHelper {

    void startSunshineActivity();

    /*private final SunshineService sunshineService;

    private static final String TAG = DataManager.class.getSimpleName();
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(SunshineService sunshineService, SharedPrefsHelper mSharedPrefsHelper) {
        this.sunshineService = sunshineService;
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }

    public Flowable<Sunshine> getDailyWeatherReport(String place) {


        return sunshineService.getWeatherReport(place,
                Integer.toString(ConstantsUtil.COUNT),
                ConstantsUtil.UNITS,
                ConstantsUtil.FORMAT_PARAM,
                ConstantsUtil.WEATHER_API_KEY);

    }

    public void storeLocationDetails(String location) {
        mSharedPrefsHelper.put(ConstantsUtil.LOCATION_KEY, location);
    }

    public String getDefaultLocation() {

        return mSharedPrefsHelper.get(ConstantsUtil.LOCATION_KEY, ConstantsUtil.DEFAULT_LOCATION);
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPrefsHelper.getSharedPreferences();
    }*/


}
