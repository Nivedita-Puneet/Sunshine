package com.nivedita.weatherutility.di.module;


import com.nivedita.weatherutility.model.Network.WeatherService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*Define a Network module class */
/* It separates the concerns of network layer.*/
@Module
public class NetworkModule {

    @Provides
    @Singleton
    WeatherService provideWeatherServiceAPI() {

        return WeatherService.CREATOR.getWeatherServiceAPI();
    }
}
