package com.nivedita.sunshine.di.module;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.nivedita.sunshine.di.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * The main module which defines dependencies for Main Activity.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity getActivity() {
        return this.activity;
    }

    @Provides
    @ActivityContext
    Activity getContext() {
        return this.activity;
    }

    @Provides
    LinearLayoutManager linearLayoutManager() {
        return new LinearLayoutManager(activity);
    }
}
