package com.climify.Services;

import com.climify.Client.WeatherApiClient;
import com.climify.Models.DTO.WeatherResponse;
import com.climify.Models.Exceptions.WeatherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    private final CacheService cacheService;

    @Autowired
    public WeatherService(WeatherApiClient weatherApiClient, CacheService cacheService) {
        this.weatherApiClient = weatherApiClient;
        this.cacheService = cacheService;
    }

    public WeatherResponse getWeather(String city) {
        String key = city.toLowerCase();
        WeatherResponse cached = cacheService.get(key);

        if (cached != null) {
            return cached;
        }

        WeatherResponse response = weatherApiClient.fetchWeather(city);
        if (response == null) {
            throw new WeatherNotFoundException("Weather for city '" + city + "' not found.");
        } else {
            cacheService.put(key, response);
        }

        return response;
    }
}
