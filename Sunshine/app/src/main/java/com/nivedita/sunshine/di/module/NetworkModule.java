package com.nivedita.sunshine.di.module;

import com.nivedita.sunshine.model.network.WeatherService;

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
    WeatherService provideWeatherServiceAPI() {

        return WeatherService.CREATOR.getWeatherServiceAPI();
    }
}