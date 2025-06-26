package com.climify.Services.Interfaces;

import com.climify.Models.DTO.WeatherResponse;

public interface ICacheService {
    WeatherResponse get(String city);
    void put(String city, WeatherResponse weatherResponse);
}
