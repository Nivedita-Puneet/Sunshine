package com.nivedita.sunshine.presenter;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.utility.rx.SchedulerProvider;
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
    private SchedulerProvider schedulerProvider;

    @Inject
    public SunshinePresenter(DataManager mDataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {

        this.mDataManager = mDataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void attachView(SunshineView sunshineView) {

        super.attachView(sunshineView);
        compositeDisposable.add(getWeatherReports());
    }

    private Disposable getWeatherReports() {

        return mDataManager.getDailyWeatherReports(mDataManager.getLocationDetails())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui()).subscribe(new Consumer<Sunshine>() {
                    @Override
                    public void accept(Sunshine sunshine) throws Exception {
                        getMvpView().showWait();
                        if (!sunshine.getList().isEmpty()) {
                            getMvpView().showDailyForecast(sunshine);
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
    public void detachView() {
        super.detachView();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }


}
