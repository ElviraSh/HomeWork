package ru.itis.weather;

import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.itis.weather.weather_api.entities.one_day.City;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;

public class WeatherService {
    private static WeatherAPI weatherAPI;
    private static final String KEY = "1e53b1fd8dbf0137cf69ae010c97f7d4";


    public static WeatherAPI getAPI(){
        if(weatherAPI == null){
            Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            weatherAPI = retrofit.create(WeatherAPI.class);
        }
        return weatherAPI;
    }

    public static MyWeather getAllWeatherDataAboutCities(List<City> cities) throws Exception {
        String idString = "";
        for (City city : cities) {
            idString = idString + "," + city.getId();
        }
        if(idString.length()>1) {
            idString = idString.substring(1);
        }
        Response<MyWeather> response = WeatherService.getAPI().getWeatherById(idString, KEY).execute();
        return response.body();
    }

    public static MyWeather getCityWeatherByName(String name) throws Exception{
        Response<MyWeather> response = WeatherService.getAPI().getWeatherByName(name, KEY).execute();
        return response.body();
    }
}
