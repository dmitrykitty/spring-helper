package com.dnikitin.springbootproperties.config;

import com.dnikitin.springbootproperties.config.props.RestaurantProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RestaurantProperties.class)
public class AppConfig {
}
