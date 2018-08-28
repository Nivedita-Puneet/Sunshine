package com.nivedita.sunshine.di.component;

import android.app.Application;
import android.content.Context;

import com.nivedita.sunshine.di.SunshineApplication;
import com.nivedita.sunshine.di.module.ApplicationModule;
import com.nivedita.sunshine.di.module.NetworkModule;
import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.SharedPrefsHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Defining components to establish connection between modules and class which needs dependencies
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(SunshineApplication mApplication);

    Application application();

    DataManager getDataManager();

    @ApplicationContext
    Context context();

}
