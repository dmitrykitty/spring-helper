package com.dnikitin.spring.basic.config;

import com.dnikitin.spring.basic.staff.Barista;
import com.dnikitin.spring.basic.staff.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //source of bean definition IoC
@ComponentScan("com.dnikitin.spring.basic") //inside this packet scan for beans
public class RestaurantConfiguration {

    @Bean
    public Customer customer(Barista barista) {
        return new Customer(barista);
    }
}
