package com.climify.Models.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CurrentConditions {
    private String datetime;
    private long datetimeEpoch;
    private double temp;
    private double feelslike;
    private double humidity;
    private double dew;
    private double precip;
    private double precipprob;
    private double snow;
    private double snowdepth;
    private List<String> preciptype;
    private Double windgust;
    private double windspeed;
    private double winddir;
    private double pressure;
    private double visibility;
    private double cloudcover;
    private double solarradiation;
    private double solarenergy;
    private double uvindex;
    private String conditions;
    private String icon;
    private List<String> stations;
    private String source;
    private String sunrise;
    private long sunriseEpoch;
    private String sunset;
    private long sunsetEpoch;
    private double moonphase;
}
