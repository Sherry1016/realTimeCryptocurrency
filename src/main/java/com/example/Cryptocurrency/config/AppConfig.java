package com.example.Cryptocurrency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.Format;
import java.text.SimpleDateFormat;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Format getUTCTimeFormat() {
        return new SimpleDateFormat("YYYY-DD-MM HH:MM:SS");
    }
}
