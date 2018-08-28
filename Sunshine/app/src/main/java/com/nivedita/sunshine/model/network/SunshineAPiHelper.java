package com.nivedita.sunshine.model.network;

import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.utility.ConstantsUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Class used to get response from rest service.
 */
@Singleton
public class SunshineAPiHelper implements Apihelper{

    private final SunshineService sunshineService;

    @Inject
    public SunshineAPiHelper(SunshineService sunshineService){
        this.sunshineService = sunshineService;
    }

    @Override
    public Flowable<Sunshine> getDailyWeatherReports(String place) {

        return sunshineService.getWeatherReport(place,
                Integer.toString(ConstantsUtil.COUNT),
                ConstantsUtil.UNITS,
                ConstantsUtil.FORMAT_PARAM,
                ConstantsUtil.WEATHER_API_KEY);
    }
}
