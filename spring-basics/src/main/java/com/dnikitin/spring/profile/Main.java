package com.dnikitin.spring.profile;

import com.dnikitin.spring.profile.bean.CoffeeShop;
import com.dnikitin.spring.profile.bean.LazyBean;
import com.dnikitin.spring.profile.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        CoffeeShop coffeeShop = context.getBean(CoffeeShop.class);
        coffeeShop.makeCoffee();
        coffeeShop.printShopName();

        context.getBean(LazyBean.class);
    }
}
