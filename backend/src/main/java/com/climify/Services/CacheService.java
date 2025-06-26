package com.climify.Services;

import com.climify.Models.DTO.WeatherResponse;
import com.climify.Services.Interfaces.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CacheService implements ICacheService {

    private final ValueOperations<String, WeatherResponse> valueOperations;

    @Autowired
    public CacheService(RedisTemplate<String, WeatherResponse> redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    public WeatherResponse get(String city) {
        return valueOperations.get(city);
    }

    public void put(String city, WeatherResponse weatherResponse) {
        valueOperations.set(city, weatherResponse, Duration.ofHours(12));
    }
}
