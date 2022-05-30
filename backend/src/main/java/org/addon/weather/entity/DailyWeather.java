package org.addon.weather.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_ABSENT)
public class DailyWeather extends WeatherDataBase {
    private WeatherTemp temp;
    private WeatherFeelsLike feelsLike;

    public WeatherTemp getTemp() {
        return this.temp;
    }

    public void setTemp(WeatherTemp temp) {
        this.temp = temp;
    }

    public WeatherFeelsLike getFeelsLike() {
        return this.feelsLike;
    }

    public void setFeelsLike(WeatherFeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

}
