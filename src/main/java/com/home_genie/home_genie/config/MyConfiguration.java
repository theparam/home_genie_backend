package com.home_genie.home_genie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration {

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//            	registry.addMapping("/**")
//        		.allowedOrigins("http:/localhost:8080/")
//        		.allowedMethods("POST","GET","PUT", "DELETE")
//        			.allowedHeaders("Content-Type", "Accept", "Access-Control-Allow-Credentials","Access-Control-Allow-Methods","Access-Control-Allow-Origin")
//        		.allowCredentials(false).maxAge(3600);            }
//        };
//    }
}