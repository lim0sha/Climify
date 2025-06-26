package com.climify.Services;

import com.climify.Client.Interfaces.IWeatherApiClient;
import com.climify.Models.DTO.WeatherResponse;
import com.climify.Models.Exceptions.WeatherNotFoundException;
import com.climify.Services.Interfaces.ICacheService;
import com.climify.Services.Interfaces.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IWeatherService {

    private final IWeatherApiClient weatherApiClient;
    private final ICacheService cacheService;

    @Autowired
    public WeatherService(IWeatherApiClient weatherApiClient, ICacheService cacheService) {
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
