package com.dnikitin.spring.event;

import com.dnikitin.spring.event.config.AppConfig;
import com.dnikitin.spring.event.events.bean.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.placeOrder("Pizza Chorizzo");
        restaurant.placeOrder("Steak Medium Rare");
        restaurant.placeOrder("Salad");
        restaurant.placeOrder("Vodka");
        restaurant.placeOrder("Ice Cream");

    }
}
