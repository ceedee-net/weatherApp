package org.addon.weather.entity;

import java.util.List;

public class WeatherDataBase {

    private Long dt;
    private Long sunrise;
    private Long sunset;
    private Long moonrise;
    private Long moonset;
    private Double moon_phase;
    private Double pressure;
    private Double humidity;
    private Double dew_point;
    private Double uvi;
    private Double clouds;
    private Long visibility;
    private Double wind_speed;
    private Long wind_deg;
    private Double wind_gust;
    private List<WeatherInfo> weather;
    private Double pop;


    public Long getDt() {
        return this.dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getSunrise() {
        return this.sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return this.sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Long getMoonrise() {
        return this.moonrise;
    }

    public void setMoonrise(Long moonrise) {
        this.moonrise = moonrise;
    }

    public Long getMoonset() {
        return this.moonset;
    }

    public void setMoonset(Long moonset) {
        this.moonset = moonset;
    }

    public Double getMoon_phase() {
        return this.moon_phase;
    }

    public void setMoon_phase(Double moon_phase) {
        this.moon_phase = moon_phase;
    }

    public Double getPressure() {
        return this.pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getDew_point() {
        return this.dew_point;
    }

    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Double getUvi() {
        return this.uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public Double getClouds() {
        return this.clouds;
    }

    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    public Long getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Double getWind_speed() {
        return this.wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Long getWind_deg() {
        return this.wind_deg;
    }

    public void setWind_deg(Long wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Double getWind_gust() {
        return this.wind_gust;
    }

    public void setWind_gust(Double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public List<WeatherInfo> getWeather() {
        return this.weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }

    public Double getPop() {
        return this.pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

}
