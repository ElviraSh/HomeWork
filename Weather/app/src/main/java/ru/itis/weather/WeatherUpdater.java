package ru.itis.weather;

import android.os.AsyncTask;

import java.util.List;

import ru.itis.weather.weather_api.entities.one_day.City;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;
import ru.itis.weather.weather_api.providers.NotLoadedException;


public class WeatherUpdater extends AsyncTask<List<City>, Void, MyWeather> {
    private final AsyncTaskInterface listener;

    public WeatherUpdater(AsyncTaskInterface listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        listener.onTaskStarted();
    }

    @Override
    protected MyWeather doInBackground(List<City>... params) {
        MyWeather weather;
        try {
            weather = WeatherService.getAllWeatherDataAboutCities(params[0]);
            if(weather == null){
                weather = new MyWeather(new NotLoadedException("Can`t load from server"));
            }

        } catch (Exception e) {
            weather = new MyWeather(new NotLoadedException("Can`t load from server"));
        }
        return weather;
    }

    @Override
    protected void onPostExecute(MyWeather weather) {
        listener.onTaskFinished(weather);
    }
}