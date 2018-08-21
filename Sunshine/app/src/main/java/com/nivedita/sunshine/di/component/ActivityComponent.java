package com.nivedita.sunshine.di.component;

import com.nivedita.sunshine.MainActivity;
import com.nivedita.sunshine.di.module.ActivityModule;
import com.nivedita.sunshine.di.scope.PerActivity;

import dagger.Component;

/**
 * Component defined to provide dependencies to main activity.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
