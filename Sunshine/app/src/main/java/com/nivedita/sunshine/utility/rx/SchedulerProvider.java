package com.nivedita.sunshine.utility.rx;

import io.reactivex.Scheduler;

/**
 * Create an interface for scheduler provider
 */

public interface SchedulerProvider {

    Scheduler ui();
    Scheduler computation();
    Scheduler io();
}
