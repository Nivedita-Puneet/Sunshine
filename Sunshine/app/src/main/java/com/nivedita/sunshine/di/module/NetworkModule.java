package com.nivedita.sunshine.di.module;

import com.nivedita.sunshine.model.network.SunshineService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * A module class defined to get response from retrofit
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    SunshineService provideWeatherServiceAPI() {

        return SunshineService.CREATOR.getWeatherServiceAPI();
    }
}