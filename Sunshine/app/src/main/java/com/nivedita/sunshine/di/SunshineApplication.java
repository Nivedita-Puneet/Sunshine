package com.nivedita.sunshine.di;

import android.app.Application;

import com.nivedita.sunshine.di.component.ApplicationComponent;
import com.nivedita.sunshine.di.component.DaggerApplicationComponent;
import com.nivedita.sunshine.di.module.ApplicationModule;
import com.nivedita.sunshine.di.module.NetworkModule;
import com.nivedita.sunshine.model.DataManager;

import javax.inject.Inject;

/**
 * The application subclassed to generate application level dependency injection..
 */

public class SunshineApplication extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule()).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
