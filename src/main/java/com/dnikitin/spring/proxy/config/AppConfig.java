package com.dnikitin.spring.proxy.config;

import com.dnikitin.spring.proxy.bean.Customer;
import com.dnikitin.spring.proxy.bean.IWaiter;
import com.dnikitin.spring.proxy.bean.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dnikitin.spring.proxy")
public class AppConfig {

    @Bean
    public IWaiter john() {
        return new Waiter("John");
    }

    @Bean
    public Customer kris(){
        return new Customer("Kris");
    }

    @Bean
    public Customer dima(){
        return new Customer("Dima");
    }

    @Bean
    public Customer sara(){
        return new Customer("Sara");
    }
}
