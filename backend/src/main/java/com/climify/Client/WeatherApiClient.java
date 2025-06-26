package com.climify.Client;

import com.climify.Client.Interfaces.IWeatherApiClient;
import com.climify.Models.DTO.WeatherResponse;
import com.climify.Models.Exceptions.CityNotFoundException;
import com.climify.Models.Exceptions.WeatherApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiClient implements IWeatherApiClient {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.apiKey = System.getProperty("VC_API_KEY", "default_key_if_not_set");
    }

    public WeatherResponse fetchWeather(String city) {
        try {
            String url = String.format(
                    "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?key=%s",
                    city, apiKey
            );

            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new CityNotFoundException("City not found: " + city);
        } catch (Exception e) {
            throw new WeatherApiException("Error while getting data from API: ", e);
        }
    }
}

