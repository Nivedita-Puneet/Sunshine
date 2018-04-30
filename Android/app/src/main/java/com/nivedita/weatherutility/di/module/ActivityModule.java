package com.nivedita.weatherutility.di.module;

import android.app.Activity;
import android.content.Context;

import com.nivedita.weatherutility.di.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity){
        this.mActivity = mActivity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }
}
