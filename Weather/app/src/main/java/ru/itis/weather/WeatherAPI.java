package ru.itis.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;


public interface WeatherAPI {
    @GET("/data/2.5/group?units=metric&lang=ru")
    Call<MyWeather> getWeatherById(@Query("id") String id, @Query("appid") String apiKey);

    @GET("/data/2.5/find?units=metric&lang=ru")
    Call<MyWeather> getWeatherByName(@Query("q") String name, @Query("appid") String apiKey);

}
