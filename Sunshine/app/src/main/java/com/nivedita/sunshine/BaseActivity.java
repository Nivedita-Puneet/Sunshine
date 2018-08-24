package com.nivedita.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nivedita.sunshine.di.SunshineApplication;
import com.nivedita.sunshine.di.component.ActivityComponent;
import com.nivedita.sunshine.di.component.DaggerActivityComponent;
import com.nivedita.sunshine.di.module.ActivityModule;

/**
 * Base activity for other activities in application.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this))
                .applicationComponent(((SunshineApplication) getApplication()).getComponent()).build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

}
