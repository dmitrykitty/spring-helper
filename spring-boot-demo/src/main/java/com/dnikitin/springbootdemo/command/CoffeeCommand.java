package com.dnikitin.springbootdemo.command;

import com.dnikitin.springbootdemo.bean.CoffeeShop;
import com.dnikitin.springbootdemo.model.CoffeeOrder;
import com.dnikitin.springbootdemo.model.CoffeeType;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
public class CoffeeCommand {

    private final CoffeeShop coffeeShop;

    public CoffeeCommand(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Command(name = "order", description = "Order a coffee")
    public String order(
            @Option(longName = "type", shortName = 't', required = true, description = "Coffee type to order")
            CoffeeType coffeeType
    ) {
        return coffeeShop.processOrder(new CoffeeOrder(coffeeType));
    }
}
