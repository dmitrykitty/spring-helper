package com.dnikitin.spring.proxy;

import com.dnikitin.spring.proxy.bean.Customer;
import com.dnikitin.spring.proxy.bean.IWaiter;
import com.dnikitin.spring.proxy.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IWaiter waiter = context.getBean(IWaiter.class);
        Customer dima = context.getBean("dima", Customer.class);
        Customer sara = context.getBean("sara", Customer.class);
        Customer kris = context.getBean("kris", Customer.class);

        for(int i = 0; i < 3; i++){
            new Thread(()-> dima.placeOrder(waiter)).start();
            new Thread(()-> sara.placeOrder(waiter)).start();
            new Thread(()-> kris.placeOrder(waiter)).start();
        }
    }
}
