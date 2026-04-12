package com.dnikitin.spring.basic.staff;

import org.springframework.stereotype.Component;

public class Customer {
    private final Barista barista;

    public Customer(Barista barista) {
        this.barista = barista;
    }
    public void makeOrder(String order) {
        System.out.println("Make order:  " + order);
        barista.makeOrder(order);
    }
}
