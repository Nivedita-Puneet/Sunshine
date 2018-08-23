package com.nivedita.sunshine.mvp;

import com.nivedita.sunshine.utility.rx.SchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Test Scheduler provider to test the schedulers in android.
 */

public class TestSchedulerProvider implements SchedulerProvider{

    private final TestScheduler mTestScheduler;

    public TestSchedulerProvider(TestScheduler mTestScheduler){
        this.mTestScheduler = mTestScheduler;
    }

    @Override
    public Scheduler ui() {
        return mTestScheduler;
    }

    @Override
    public Scheduler computation() {
        return mTestScheduler;
    }

    @Override
    public Scheduler io() {
        return mTestScheduler;
    }
}
