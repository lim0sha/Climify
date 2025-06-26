package com.climify.Client.Interfaces;

import com.climify.Models.DTO.WeatherResponse;

public interface IWeatherApiClient {
    WeatherResponse fetchWeather(String city);
}
