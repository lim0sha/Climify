package com.climify.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/climify")
                .setViewName("forward:/index.html");

        registry.addViewController("/climify/")
                .setViewName("forward:/index.html");

        registry.addViewController("/climify/{x:[\\w\\-]+}")
                .setViewName("forward:/index.html");

        registry.addViewController("/climify/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
                .setViewName("forward:/index.html");
    }
}
