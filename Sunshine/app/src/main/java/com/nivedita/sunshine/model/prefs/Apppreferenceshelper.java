package com.nivedita.sunshine.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.di.scope.PreferenceInfo;
import com.nivedita.sunshine.utility.ConstantsUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class to be accessed at an application level
 */
@Singleton
public class Apppreferenceshelper implements PrefsHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public Apppreferenceshelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName){

        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
    @Override
    public String getLocationDetails() {
        return mPrefs.getString(ConstantsUtil.DEFAULT_LOCATION, null);
    }

    @Override
    public void setLocationDetails(String place) {

        mPrefs.edit().putString(ConstantsUtil.LOCATION_KEY, place).apply();
    }
}
