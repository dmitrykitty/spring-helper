package com.dnikitin.springbootproperties;

import com.dnikitin.springbootproperties.config.props.RestaurantProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class SpringBootPropertiesApplication {

    @Autowired
    private RestaurantProperties restaurantProperties;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPropertiesApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData(ApplicationReadyEvent event) {
        System.out.println("Name: " + restaurantProperties.getName());
        System.out.println("Menu: " + restaurantProperties.getMenu());
        System.out.println("Employees: " + restaurantProperties.getEmployees());
    }

}
