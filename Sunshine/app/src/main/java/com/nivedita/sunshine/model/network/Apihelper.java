package com.nivedita.sunshine.model.network;

import com.nivedita.sunshine.model.pojo.Sunshine;

import io.reactivex.Flowable;

/**
 * Interface used to fetch flowable data
 */

public interface Apihelper {

    Flowable<Sunshine> getDailyWeatherReports(String place);
}
