package com.nivedita.sunshine.model;

import android.content.Context;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.model.network.Apihelper;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.prefs.PrefsHelper;

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

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PrefsHelper prefsHelper, Apihelper apihelper) {

        this.context = context;
        this.prefsHelper = prefsHelper;
        this.apihelper = apihelper;
    }


    public String getLocationDetails() {
        return prefsHelper.getLocationDetails();
    }


    public void setLocationDetails(String place) {
        prefsHelper.setLocationDetails(place);
    }

    public Flowable<Sunshine> getDailyWeatherReports(String place) {

        String location = this.getLocationDetails();
        return apihelper.getDailyWeatherReports(place);
    }

    public void startSunshineActivity() {

    }

    @Override
    public void onPageLoad() {

    }
}
