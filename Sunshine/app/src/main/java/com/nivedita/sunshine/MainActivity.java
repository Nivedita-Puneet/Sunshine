package com.nivedita.sunshine;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.WeatherList;
import com.nivedita.sunshine.presenter.SunshineBasePresenter;
import com.nivedita.sunshine.utility.DataProcessUtil;
import com.nivedita.sunshine.utility.SunshineDateUtil;
import com.nivedita.sunshine.view.SunshineView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity implements SunshineView {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    SunshineAdapter sunshineAdapter;

    /*Array list to process the input data and process it.*/
    List<String> weatherForecast;


    @Inject
    SunshineBasePresenter<SunshineView> sunshinePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);

        initializeControls();
    }

    private void initializeControls() {

        sunshinePresenter.attachView(this);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);

        sunshineAdapter = new SunshineAdapter(MainActivity.this, new SunshineAdapter.WeatherReportAdapterOnclickHandler() {
            @Override
            public void clickListener(String weatherForToday) {


            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        sunshinePresenter.onViewInitialized();
    }

    @Override
    public void showDailyForecast(List<WeatherList> sunshine) {

        weatherForecast = new ArrayList<>();
        /*Process the data to display data to user*/
        long localDate = System.currentTimeMillis();
        long utcDate = SunshineDateUtil.getUTCDateFromLocal(localDate);
        long startDay = SunshineDateUtil.normalizeDate(utcDate);

        long dateTimeMillis;
        double high;
        double low;
        String description;

        for (int i = 0; i < sunshine.size(); i++) {

            String date;
            String highAndLow;

            dateTimeMillis = startDay + SunshineDateUtil.DAY_IN_MILLIS * i;
            date = SunshineDateUtil.getFriendlyDateString(MainActivity.this,
                    dateTimeMillis, false);
            Log.i(MainActivity.class.getSimpleName(), date);

            /*Get the description paramater*/
            description = sunshine.get(i).getWeather().get(0).getMain();

            /*get the low and max temprature.*/
            low = sunshine.get(i).getTemp().getMin();
            high = sunshine.get(i).getTemp().getMax();
            highAndLow = DataProcessUtil.formatHighLows(MainActivity.this,
                    high, low);

            weatherForecast.add(date + "-" + description + "-" + highAndLow);
        }

        sunshineAdapter.setmWeatherData(weatherForecast);

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
