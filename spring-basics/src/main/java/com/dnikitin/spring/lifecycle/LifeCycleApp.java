package com.dnikitin.spring.lifecycle;

import com.dnikitin.spring.lifecycle.bean.Coffee;
import com.dnikitin.spring.lifecycle.bean.CoffeeShop;
import com.dnikitin.spring.lifecycle.config.LifeCycleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        CoffeeShop coffeeShop = context.getBean(CoffeeShop.class);
        coffeeShop.makeCoffee("Arabica");

        coffeeShop.makeCoffee("Cherry", "milk");
        coffeeShop.makeCoffee("Cherry", "sugar");
    }
}
