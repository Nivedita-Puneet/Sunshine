package com.nivedita.sunshine.di.module;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.nivedita.sunshine.di.scope.ActivityContext;
import com.nivedita.sunshine.di.scope.PerActivity;
import com.nivedita.sunshine.model.network.SunshineService;
import com.nivedita.sunshine.presenter.SunshinePresenter;
import com.nivedita.sunshine.utility.rx.AppSchedulerProvider;
import com.nivedita.sunshine.utility.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

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

    @Provides
    CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
