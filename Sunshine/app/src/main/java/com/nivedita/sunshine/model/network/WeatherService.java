package com.nivedita.sunshine.model.network;

import com.nivedita.sunshine.model.pojo.Sunshine;
import com.nivedita.sunshine.utility.ConstantsUtil;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * A retrofit class which returns an instance to get response from weather api.
 */

public interface WeatherService {

    @GET("daily")
    Flowable<Sunshine> getWeatherReport(@Query("q") String place,
                                        @Query("cnt") String count,
                                        @Query("units") String unit,
                                        @Query("mode") String response,
                                        @Query("appid") String apiKey);

    /*Helper class to create a service*/

    class CREATOR {

        public static WeatherService getWeatherServiceAPI() {

            Retrofit retrofit = new Retrofit.Builder().client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(ConstantsUtil.BASE_URL).build();
            return retrofit.create(WeatherService.class);
        }

        private static OkHttpClient buildClient() {

            return new OkHttpClient
                    .Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        }

    }


}
