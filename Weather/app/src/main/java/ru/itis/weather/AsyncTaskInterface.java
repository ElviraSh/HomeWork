package ru.itis.weather;

import ru.itis.weather.weather_api.entities.one_day.MyWeather;

/**
 * Created by ilmaz on 06.11.16.
 */

public interface AsyncTaskInterface {
    void onTaskStarted();
    void onTaskFinished(MyWeather weather);
}
