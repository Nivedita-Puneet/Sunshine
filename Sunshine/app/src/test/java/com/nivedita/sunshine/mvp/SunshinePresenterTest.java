package com.nivedita.sunshine.mvp;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.pojo.WeatherList;
import com.nivedita.sunshine.presenter.SunshinePresenter;
import com.nivedita.sunshine.view.SunshineView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


/**
 * Class created to define presenter test.
 */
@RunWith(MockitoJUnitRunner.class)
public class SunshinePresenterTest {

    @Mock
    SunshineView sunshineView;

    @Mock
    DataManager mDataManager;

    private SunshinePresenter sunshinePresenter;

    private TestScheduler mTestScheduler;

    Sunshine sunshine;

    CompositeDisposable compositeDisposable;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        sunshine = new Sunshine();

        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        //TODO: make changes to sunshine presenter class
        sunshinePresenter = new SunshinePresenter(mDataManager, testSchedulerProvider, compositeDisposable);
        sunshinePresenter.attachView(sunshineView);

    }

    @Test
    public void fetchWeatherDetailsList(){

        Sunshine sunshine = new Sunshine();
        List<WeatherList> weatherReports = sunshine.getList();
        doReturn(Flowable.just(sunshine)).when(mDataManager).getDailyWeatherReports("Sydney");

        sunshinePresenter.onViewInitialized();
        mTestScheduler.triggerActions();

        verify(sunshineView).showWait();

    }

}
