package com.rama.rest.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CallerConfig {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder
      .setConnectTimeout(Duration.ofMillis(3000))
      .setReadTimeout(Duration.ofMillis(3000))
      .build();
  }
}
