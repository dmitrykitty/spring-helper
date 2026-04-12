package com.dnikitin.spring.lifecycle.bean;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Coffee {
    private final String type;


    public Coffee(String type) {
        this.type = type;
    }

    @PostConstruct
    public void createCoffee() {
        System.out.println("create Coffee from Bean initMethod with type: " + type);
    }

    public void coffee() {
        System.out.println("Coffee " +  type + " is ready");
    }

    @PreDestroy
    public void destroyCoffee() {
        System.out.println("destroy Coffee from Bean destroyMethod with type: " + type);

    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                '}';
    }
}
