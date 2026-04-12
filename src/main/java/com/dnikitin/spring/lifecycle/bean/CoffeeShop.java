package com.dnikitin.spring.lifecycle.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoffeeShop implements InitializingBean, DisposableBean {

    private final ObjectProvider<Coffee> coffeeProvider;

    private final Map<String, Ingredient> ingredientMap;

    public CoffeeShop(ObjectProvider<Coffee> coffeeProvider, Map<String, Ingredient> ingredientMap) {
        this.coffeeProvider = coffeeProvider;
        this.ingredientMap = ingredientMap;
    }

    @PostConstruct
    public void openShop() {
        System.out.println("open Shop from PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("open Shop from InitializingBean");
    }

    //Bean(initMethod = ...)


    public void makeCoffee(String type) {
        System.out.println("making Coffee " + type);
        coffeeProvider.getObject(type);
    }

    public void makeCoffee(String type, String ingredient) {
        Coffee coffee = coffeeProvider.getObject(type);
        System.out.println("making Coffee " + type + " with: " + ingredientMap.get(ingredient) + ". Coffee: " + coffee);

    }

    @PreDestroy
    public void closeShop() {
        System.out.println("close Shop from PreDestroy");
    }


    @Override
    public void destroy() {
        System.out.println("close Shop from Destroy");

    }
}
