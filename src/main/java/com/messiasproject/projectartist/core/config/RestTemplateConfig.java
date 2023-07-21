package com.messiasproject.projectartist.core.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public static RestTemplate getRestTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.defaultHeader("x-api-key", "sCaf51dZG3wiKTKL3INgr61_eJ_mts8Hy7yt").defaultHeader("Accept", "application/json").build();
    }

    @Bean
    public static RestTemplate getRestTemplateLast() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.build();
    }
}
