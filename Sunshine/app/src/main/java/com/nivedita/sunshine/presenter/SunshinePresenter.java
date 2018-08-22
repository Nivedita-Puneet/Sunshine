package com.nivedita.sunshine.presenter;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.Sunshine;
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

public class SunshinePresenter extends BasePresenter<SunshineView> {

    private final DataManager mDataManager;
    private CompositeDisposable compositeDisposable;

    @Inject
    public SunshinePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(SunshineView sunshineView) {
        super.attachView(sunshineView);

        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(getWeatherReports());
    }

    private Disposable getWeatherReports() {

        return sendRequestToApiObservable().subscribe(new Consumer<Sunshine>() {
            @Override
            public void accept(Sunshine weatherReport) throws Exception {

                getMvpView().showWait();
                if (!weatherReport.getList().isEmpty()) {
                    getMvpView().showDailyForecast(weatherReport);
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


    private Flowable<Sunshine> sendRequestToApiObservable() {

        String value = mDataManager.getDefaultLocation();
        return mDataManager.getDailyWeatherReport(value).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void detachView() {
        super.detachView();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }


}
