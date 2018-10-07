package com.nivedita.sunshine.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.di.scope.DatabaseInfo;
import com.nivedita.sunshine.di.scope.PreferenceInfo;
import com.nivedita.sunshine.model.AppDataManager;
import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.SharedPrefsHelper;
import com.nivedita.sunshine.model.db.AppDBHelper;
import com.nivedita.sunshine.model.db.DBHelper;
import com.nivedita.sunshine.model.network.Apihelper;
import com.nivedita.sunshine.model.network.SunshineAPiHelper;
import com.nivedita.sunshine.model.prefs.Apppreferenceshelper;
import com.nivedita.sunshine.model.prefs.PrefsHelper;
import com.nivedita.sunshine.utility.ConstantsUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This class defines dependencies at an application level
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplicationInstance() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return ConstantsUtil.WEATHERSHAREDPREFS;
    }


    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager getDataManager(AppDataManager dataManager){
        return dataManager;
    }

    @Provides
    @Singleton
    Apihelper getSunShineAPIHelper(SunshineAPiHelper sunshineAPiHelper){
        return sunshineAPiHelper;
    }

    @Provides
    @Singleton
    PrefsHelper getSharedPrefsHelper(Apppreferenceshelper sharedPrefsHelper){
        return sharedPrefsHelper;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return ConstantsUtil.DB_NAME;
    }

    }


