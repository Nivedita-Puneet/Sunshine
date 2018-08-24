package com.nivedita.sunshine.model.network;

import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.utility.ConstantsUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by PUNEETU on 23-08-2018.
 */
@Singleton
public class SunshineAPiHelper {

    private final SunshineService sunshineService;

    @Inject
    public SunshineAPiHelper(SunshineService sunshineService){
        this.sunshineService = sunshineService;
    }

    public Flowable<Sunshine> getDailyWeatherReports(String place) {

        return sunshineService.getWeatherReport(place,
                Integer.toString(ConstantsUtil.COUNT),
                ConstantsUtil.UNITS,
                ConstantsUtil.FORMAT_PARAM,
                ConstantsUtil.WEATHER_API_KEY);
    }
}
