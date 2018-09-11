package com.nivedita.sunshine.model.db;

import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.model.pojo.Temp;
import com.nivedita.sunshine.model.pojo.Weather;
import com.nivedita.sunshine.model.pojo.WeatherList;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Creating a new DBHelper interface to store weather details.
 */

public interface DBHelper {

    Flowable<Long> persistSunshine(final Sunshine sunshine);

    Flowable<List<WeatherList>> getWeatherListDetails(final Sunshine sunshine);

    Flowable<List<Weather>> getWeatherDetails();

    Flowable<Weather> getWeather();

    Flowable<Temp> getTemp();


}
