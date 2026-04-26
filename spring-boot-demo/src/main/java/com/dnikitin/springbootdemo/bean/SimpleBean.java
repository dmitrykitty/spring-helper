package com.dnikitin.springbootdemo.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct from SimpleBean");
    }

    public void printInf(){
        System.out.println("I'm SimpleBean");
    }
}
