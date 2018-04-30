package com.nivedita.weatherutility.di.component;


import android.app.Application;
import android.content.Context;

import com.nivedita.weatherutility.di.module.ApplicationModule;
import com.nivedita.weatherutility.di.module.NetworkModule;
import com.nivedita.weatherutility.di.scope.ApplicationContext;
import com.nivedita.weatherutility.model.datalayer.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Application application();

    DataManager dataManager();

    @ApplicationContext
    Context context();
}
