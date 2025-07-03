package com.climify;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@OpenAPIDefinition(
        info = @Info(
                title = "Climify API",
                version = "1.0",
                description = "API for getting weather forecasts powered by Spring Boot"
        )
)
@SpringBootApplication
@ComponentScan({"com.climify.Controllers", "com.climify.Services", "com.climify.Configs", "com.climify.Client",
        "com.climify.Models.Exceptions", "com.climify.Models.DTO", "com.climify.Middleware.RateLimiting", "com.climify.Middleware.RateLimiting.Interfaces"})
public class Application {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("VC_API_KEY", dotenv.get("VC_API_KEY"));
        try {
            SpringApplication.run(Application.class, args);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
