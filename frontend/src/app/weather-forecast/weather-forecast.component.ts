import { WeatherService } from './../service/weather.service';
import { Component, OnInit } from '@angular/core';
import { WeatherData } from '../model/weather-data';

@Component({
  selector: 'app-weather-forecast',
  templateUrl: './weather-forecast.component.html',
  styleUrls: ['./weather-forecast.component.css']
})
export class WeatherForecastComponent implements OnInit {

  weatherData!: WeatherData;

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.getWeatherForecast();
  }

  getWeatherForecast() {
    this.weatherService.getForecast(50.9317,6.9515).subscribe({
      next: data => {
        this.weatherData = data;
        // console.log(JSON.stringify(data))
      },
      error: err => console.log("Error getting Weatherdata: " + JSON.stringify(err)),
      complete: () => console.log("Loading Weatherdata completed")
    })    
  }

}
