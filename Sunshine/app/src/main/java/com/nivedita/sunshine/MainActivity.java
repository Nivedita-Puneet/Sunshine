package com.nivedita.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.WeatherList;
import com.nivedita.sunshine.presenter.SunshinePresenter;
import com.nivedita.sunshine.utility.rx.SchedulerProvider;
import com.nivedita.sunshine.view.SunshineView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity implements SunshineView {

    RecyclerView recyclerView;

    @Inject
    CompositeDisposable compositeDisposable;

    @Inject
    SchedulerProvider schedulerProvider;

    @Inject
    SunshinePresenter sunshinePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);

        initializeControls();
    }

    private void initializeControls() {

        sunshinePresenter.attachView(this);
    }


    @Override
    public void showDailyForecast(List<WeatherList> sunshine) {

    }

    @Override
    public void noWeatherReports() {

    }

    @Override
    public void showError(LogNetworkError logNetworkError) {

    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sunshinePresenter.detachView();
    }
}
