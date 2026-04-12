package com.dnikitin.spring.profile.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyBean {

    @PostConstruct
    public void init() {
        System.out.println("Lazy Bean Initialized");
    }
}
