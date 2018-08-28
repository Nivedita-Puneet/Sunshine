package com.nivedita.sunshine.presenter;

import android.util.Log;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.utility.rx.SchedulerProvider;
import com.nivedita.sunshine.view.MVPView;
import com.nivedita.sunshine.view.SunshineView;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
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

        return getDataManager().getDailyWeatherReports("Sydney")
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
}
