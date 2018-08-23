package com.nivedita.sunshine.mvp;

import com.nivedita.sunshine.model.DataManager;
import com.nivedita.sunshine.presenter.SunshinePresenter;
import com.nivedita.sunshine.view.SunshineView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

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

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception{

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        //TODO: make changes to sunshine presenter class
       // sunshinePresenter = new SunshinePresenter(mDataManager);
        sunshinePresenter.attachView(sunshineView);

    }

    @Test
    public void fetchWeatherDetailsSuccess(){

    }


}
