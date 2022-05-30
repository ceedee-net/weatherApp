package org.addon.weather.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_ABSENT)
public class OneCallWeather {
    private Double lat;
    private Double lon;
    private String timezone;
    private Double timezone_offset;

    private CurrentWeather current;
    private List<HourlyWeather> hourly;
    private List<DailyWeather> daily;
    private List<WeatherAlert> alerts;


    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getTimezone_offset() {
        return this.timezone_offset;
    }

    public void setTimezone_offset(Double timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public CurrentWeather getCurrent() {
        return this.current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public List<HourlyWeather> getHourly() {
        return this.hourly;
    }

    public void setHourly(List<HourlyWeather> hourly) {
        this.hourly = hourly;
    }

    public List<DailyWeather> getDaily() {
        return this.daily;
    }

    public void setDaily(List<DailyWeather> daily) {
        this.daily = daily;
    }

    public List<WeatherAlert> getAlerts() {
        return this.alerts;
    }

    public void setAlerts(List<WeatherAlert> alerts) {
        this.alerts = alerts;
    }
    
}
