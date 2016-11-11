package ru.itis.weather;

import android.os.AsyncTask;

import ru.itis.weather.weather_api.entities.one_day.MyWeather;
import ru.itis.weather.weather_api.providers.NotLoadedException;


public class CityWeatherGetter extends AsyncTask<String, Void, MyWeather> {
    private AsyncTaskInterface listener;

    public CityWeatherGetter(AsyncTaskInterface listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        listener.onTaskStarted();
    }

    @Override
    protected void onPostExecute(MyWeather weather) {
        listener.onTaskFinished(weather);
    }

    @Override
    protected MyWeather doInBackground(String... params) {
        MyWeather weather = null;
        try {
            weather = WeatherService.getCityWeatherByName(params[0]);
        } catch (Exception e) {
            e.printStackTrace();
            weather = new MyWeather(new NotLoadedException("Connection error"));
        }
        return weather;
    }
}
