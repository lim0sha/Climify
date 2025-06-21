package com.climify.Handlers;

import com.climify.Models.Exceptions.WeatherNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherNotFoundException.class)
    public ResponseEntity<String> handleWeatherNotFound(WeatherNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
