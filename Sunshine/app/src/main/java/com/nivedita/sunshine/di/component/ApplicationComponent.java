package com.nivedita.sunshine.di.component;

import android.app.Application;
import android.content.Context;

import com.nivedita.sunshine.di.module.ApplicationModule;
import com.nivedita.sunshine.di.module.NetworkModule;
import com.nivedita.sunshine.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Defining components to establish connection between modules and class which needs dependencies
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Application application();

    //DataManager dataManager();

    //SharedPrefsHelper getPreferenceHelper();

    @ApplicationContext
    Context context();

}
