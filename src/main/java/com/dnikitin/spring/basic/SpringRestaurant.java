package com.dnikitin.spring.basic;

import com.dnikitin.spring.basic.config.RestaurantConfiguration;
import com.dnikitin.spring.basic.staff.Barista;
import com.dnikitin.spring.basic.staff.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRestaurant {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext used for configuration with Annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(RestaurantConfiguration.class);

        Customer customer = context.getBean(Customer.class);
        customer.makeOrder("coffee");
    }
}

