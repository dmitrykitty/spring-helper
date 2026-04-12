package com.dnikitin.spring.properties;

import com.dnikitin.spring.properties.bean.Restaurant;
import com.dnikitin.spring.properties.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Restaurant bean = context.getBean(Restaurant.class);
        bean.printMainInfo();

    }
}
