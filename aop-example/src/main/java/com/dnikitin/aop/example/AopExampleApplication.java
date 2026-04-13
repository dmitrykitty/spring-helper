package com.dnikitin.aop.example;

import com.dnikitin.aop.example.bean.example.IExampleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AopExampleApplication {

    @Autowired
    private IExampleBean bean;

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event){
        bean.info();
    }

}
