package com.dnikitin.spring.spel;

import com.dnikitin.spring.spel.bean.Shop;
import com.dnikitin.spring.spel.bean.SingleSpelExample;
import com.dnikitin.spring.spel.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SingleSpelExample spelExample = context.getBean(SingleSpelExample.class);
        spelExample.printSpels();

        Shop shop = context.getBean(Shop.class);
        shop.printAllProducts();
        System.out.println("-------------");
        shop.printAllSuitableProducts();
        System.out.println("-------------");
        shop.printAllEndingProducts();
        System.out.println("-------------");
        shop.printOpeningTime();
        System.out.println("-------------");

        spelExample.simpleEvaluateExample();
        spelExample.simpleReadAndWriteExample();

    }
}
