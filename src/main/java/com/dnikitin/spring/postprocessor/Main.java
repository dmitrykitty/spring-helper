package com.dnikitin.spring.postprocessor;

import com.dnikitin.spring.postprocessor.bean.Restaurant;
import com.dnikitin.spring.postprocessor.bean.Waiter;
import com.dnikitin.spring.postprocessor.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Waiter waiter = context.getBean(Waiter.class);
        waiter.takeOrder();

        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.printInfo();


    }
}
