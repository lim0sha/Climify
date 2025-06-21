package com.climify.Models.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class WeatherResponse {
    private int queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;
    private String description;
    private List<DayWeather> days;
    private List<Object> alerts;
    private Map<String, Station> stations;
    private CurrentConditions currentConditions;
}

