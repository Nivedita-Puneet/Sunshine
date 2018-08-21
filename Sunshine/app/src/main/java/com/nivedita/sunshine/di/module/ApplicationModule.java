package com.nivedita.sunshine.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.utility.ConstantsUtil;

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
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return mApplication.getSharedPreferences(ConstantsUtil.WEATHERSHAREDPREFS, Context.MODE_PRIVATE);
    }
}


