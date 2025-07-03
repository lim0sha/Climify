package com.climify.Controllers;

import com.climify.Middleware.RateLimiting.Interfaces.IRateLimiter;
import com.climify.Models.DTO.WeatherResponse;
import com.climify.Services.Interfaces.IWeatherService;
import io.github.bucket4j.Bucket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("climify/api/weather")
public class WeatherController {
    private final IWeatherService weatherService;
    private final IRateLimiter rateLimiter;

    @Autowired
    public WeatherController(IWeatherService weatherService, IRateLimiter rateLimiter) {
        this.weatherService = weatherService;
        this.rateLimiter = rateLimiter;
    }

    @Operation(summary = "Get weather info", description = "Gets weather in the city by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Weather successfully found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = WeatherResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized, invalid API_KEY"),
            @ApiResponse(responseCode = "429", description = "Too many requests"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String clientIp = request.getRemoteAddr();

        Bucket bucket = rateLimiter.getBucket(clientIp);
        if (!bucket.tryConsume(1)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(null);
        }

        WeatherResponse weather = weatherService.getWeather(city);
        return ResponseEntity.ok(weather);
    }
}
