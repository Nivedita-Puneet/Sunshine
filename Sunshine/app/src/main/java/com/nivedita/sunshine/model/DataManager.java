package com.nivedita.sunshine.model;

import android.content.SharedPreferences;

import com.nivedita.sunshine.model.db.DBHelper;
import com.nivedita.sunshine.model.network.Apihelper;
import com.nivedita.sunshine.model.network.SunshineAPiHelper;
import com.nivedita.sunshine.model.network.SunshineService;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.prefs.PrefsHelper;
import com.nivedita.sunshine.utility.ConstantsUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;


/**
 * Interface which defines all data related operations of application.
 */
@Singleton
public interface DataManager extends Apihelper,PrefsHelper, DBHelper{

    public void onPageLoad();

   /* private SharedPrefsHelper sharedPrefsHelper;
    private SunshineAPiHelper sunshineAPiHelper;

    @Inject
    public DataManager(SharedPrefsHelper sharedPrefsHelper, SunshineAPiHelper sunshineAPiHelper) {

        this.sharedPrefsHelper = sharedPrefsHelper;
        this.sunshineAPiHelper = sunshineAPiHelper;
    }

    public String getDefaultLocation() {

        return sharedPrefsHelper.get(ConstantsUtil.LOCATION_KEY, ConstantsUtil.DEFAULT_LOCATION);
    }

    public Flowable<Sunshine> getWeatherAPIReports(String place) {

        return sunshineAPiHelper.getDailyWeatherReports(this.getDefaultLocation());
    }

    public void setDefaultLocationDetails(String place){

        sharedPrefsHelper.put(ConstantsUtil.LOCATION_KEY, place);
    }*/
}
