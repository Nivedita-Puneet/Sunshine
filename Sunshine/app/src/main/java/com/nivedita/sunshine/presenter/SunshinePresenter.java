package com.nivedita.sunshine.presenter;

import android.util.Log;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.pojo.WeatherList;
import com.nivedita.sunshine.utility.rx.SchedulerProvider;
import com.nivedita.sunshine.view.MVPView;
import com.nivedita.sunshine.view.SunshineView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * The presenter class for main activity
 */

public class SunshinePresenter<T extends SunshineView> extends BasePresenter<T>
        implements SunshineBasePresenter<T> {


    private static final String TAG = SunshinePresenter.class.getSimpleName();

    @Inject
    public SunshinePresenter(DataManager mDataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {

        super(mDataManager, schedulerProvider, compositeDisposable);
    }

    private Disposable getWeatherReports() {

        getMvpView().showWait();

        return getDataManager().getDailyWeatherReports(getDataManager().getLocationDetails())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()).subscribe(new Consumer<Sunshine>() {
                    @Override
                    public void accept(Sunshine sunshine) throws Exception {
                        if (!sunshine.getList().isEmpty()) {
                            getMvpView().showDailyForecast(sunshine.getList());
                            Log.i(TAG, sunshine.getList().get(0).getTemp().toString());
                            getMvpView().removeWait();

                        } else {
                            getMvpView().noWeatherReports();
                            getMvpView().removeWait();
                        }

                      //  SunshinePresenter.this.persistWeatherDetails(sunshine);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().showError(new LogNetworkError(throwable));
                    }
                });
    }


    @Override
    public void onViewInitialized() {
        getCompositeDisposable().add(getWeatherReports());
    }

    @Override
    public void persistWeatherDetails(Sunshine sunshine) {
        getCompositeDisposable().add(getDataManager().persistSunshine(sunshine)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        Log.i(TAG, "The sunshine is persisted successfully" + aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        getMvpView().showError(new LogNetworkError(throwable));
                    }
                }));
    }
}
