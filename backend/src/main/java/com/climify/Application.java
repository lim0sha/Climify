package com.climify;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.climify.Controllers", "com.climify.Services", "com.climify.Configs", "com.climify.Client",
        "com.climify.Models.Exceptions", "com.climify.Models.DTO"})
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
