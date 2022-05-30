package org.addon.weather.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.addon.weather.entity.GeocodingData;
import org.addon.weather.entity.OneCallWeather;

import io.quarkus.logging.Log;

@ApplicationScoped
public class WeatherService {
    
    private static final String baseUrl = "https://api.openweathermap.org/data/2.5";
    private static final String baseGeocodingUrl = "http://api.openweathermap.org/geo/1.0";
    private static final String oneCallPath = "onecall";
    private static final String apiKey = "YOUR_API_KEY";

    public OneCallWeather getOneCallWeatherForecast(Double lat, Double lon) {
        
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(baseUrl)
            .path(oneCallPath)
            .queryParam("lat", lat)
            .queryParam("lon", lon)
            .queryParam("exclude", "minutely")
            .queryParam("appid", apiKey)
            .queryParam("units", "metric")
            .queryParam("lang", "de");
       
        Log.info("target: " + target.getUri().toString());

        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
        try {
            if (response.getStatus() == 200) {
                OneCallWeather forecast = response.readEntity(OneCallWeather.class);
                return forecast;
            } else {
                return null;
            }
        } finally {
            response.close();
        }    
    }

    public List<GeocodingData> getGeocodingReverse (Double lat, Double lon, Long limit) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseGeocodingUrl).path("reverse")
        .queryParam("lon", lon)
        .queryParam("lat", lat)
        .queryParam("appid", apiKey);

        if(limit != null) 
            target = target.queryParam("limit", limit);

        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();

        try {
            if (response.getStatus() == 200) {
                List<GeocodingData> result = response.readEntity(new GenericType<List<GeocodingData>>() {});
                //response.readEntity(OneCallWeather.class);
                return result;
            } else {
                return null;
            }
        } finally {
            response.close();
        } 
    }

    public GeocodingData getGeocodingByZip (String zip, String countryCode) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseGeocodingUrl).path("zip")
        .queryParam("zip", zip+","+ (countryCode != null ? countryCode : "DE"))
        .queryParam("appid", apiKey);

        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
        try {
            if (response.getStatus() == 200) {
                GeocodingData result = response.readEntity(GeocodingData.class);
                //response.readEntity(OneCallWeather.class);
                return result;
            } else {
                return null;
            }
        } finally {
            response.close();
        } 
    }

    public List<GeocodingData> getGeocodingByCity (String city,  Long limit) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseGeocodingUrl).path("direct")
        .queryParam("q", city)
        .queryParam("limit", (limit != null ? limit : 10))
        .queryParam("appid", apiKey);

        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();

        try {
            if (response.getStatus() == 200) {
                List<GeocodingData> result = response.readEntity(new GenericType<List<GeocodingData>>() {});
                //response.readEntity(OneCallWeather.class);
                return result;
            } else {
                return null;
            }
        } finally {
            response.close();
        } 
    }
}