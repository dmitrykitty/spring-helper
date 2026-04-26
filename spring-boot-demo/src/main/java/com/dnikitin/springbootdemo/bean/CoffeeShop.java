package com.dnikitin.springbootdemo.bean;

import com.dnikitin.springbootdemo.model.CoffeeOrder;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    public String processOrder(CoffeeOrder coffeeOrder) {
        return "Coffee ordered: " + coffeeOrder.coffeeType();
    }
}
