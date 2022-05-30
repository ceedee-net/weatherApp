package org.addon.weather.boundary;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.addon.weather.control.WeatherService;

import io.quarkus.logging.Log;

@Path("/weather")
public class WeatherResource {

    @Inject WeatherService weatherService;

    @GET
    public Response getWeatherForecast(@QueryParam("lat") Double lat, @QueryParam("lon") Double lon) {
        if(lat != null && lon != null) {
            return Response.ok(weatherService.getOneCallWeatherForecast(lat, lon)).build();
        } else {
            Log.warn("Latitude and Longitude not set");
            return null;
        }
    }
    
    @GET
    @Path("geocode/reverse")
    public Response getGeocodingReverse(
                @QueryParam("lat") Double lat, 
                @QueryParam("lon") Double lon, 
                @QueryParam("limit") @DefaultValue("25") Long limit) {
        if(lat != null && lon != null) {
            return Response.ok(weatherService.getGeocodingReverse(lat, lon, limit)).build();
        } else {
            Log.warn("Latitude and Longitude not set");
            return Response.status(Status.BAD_REQUEST).entity("Parameter Latitude and Longitude not set").build();
        }
    }

    @GET
    @Path("geocode/city")
    public Response getGeocodingCity(
                @QueryParam("city") String city, 
                @QueryParam("limit") @DefaultValue("25") Long limit) {
        if(city != null) {
            return Response.ok(weatherService.getGeocodingByCity(city, limit)).build();
        } else {            
            Log.warn("city not set");
            return Response.status(Status.BAD_REQUEST).entity("Parameter city not set").build();
        }
    }

    @GET
    @Path("geocode/zip")
    public Response getGeocodingZip(
        @QueryParam("zip") String zip, 
        @QueryParam("countryCode") @DefaultValue("DE") String countryCode) {
        if(zip != null) {
            return Response.ok(weatherService.getGeocodingByZip(zip, countryCode)).build();
        } else {            
            Log.warn("zip not set");
            return Response.status(Status.BAD_REQUEST).entity("Parameter zip not set").build();
        }
    }
}