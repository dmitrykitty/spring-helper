package com.dnikitin.spring.properties.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Restaurant {

    @Value("${restaurant.name}")
    private String name;

    @Value("${restaurant.capacity}")
    private int capacity;

    @Value("#{'${restaurant.menu.itemsString}'.split(',')}")
    private List<String> menu;

    @Value("${restaurant.description}")
    private String description;

    public void printMainInfo() {
        System.out.println("Restaurant name: " + name);
        System.out.println("Restaurant capacity: " + capacity);
        System.out.println("Restaurant menu: " + menu);
        System.out.println("Restaurant description: " + description);
    }
}

