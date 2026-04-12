package com.dnikitin.spring.basic.staff;

import org.springframework.stereotype.Component;

@Component
public class Barista {
    public void makeOrder(String order){
        System.out.println("Take Order:  " + order);
    }
}
