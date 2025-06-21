package com.climify.Models.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Station {
    private double distance;
    private double latitude;
    private double longitude;
    private int useCount;
    private String id;
    private String name;
    private int quality;
    private double contribution;
}
