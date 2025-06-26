package com.climify.Services.Interfaces;

import com.climify.Models.DTO.WeatherResponse;

public interface IWeatherService {
    WeatherResponse getWeather(String city);
}
