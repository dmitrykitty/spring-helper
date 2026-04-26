package com.dnikitin.springbootdemo;

import com.dnikitin.springbootdemo.bean.SimpleBean;
import com.dnikitin.springbootdemo.command.CoffeeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.shell.core.command.annotation.EnableCommand;

@SpringBootApplication
@EnableCommand(CoffeeCommand.class)
public class SpringBootDemoApplication {

    @Autowired
    private SimpleBean simpleBean;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event){
        System.out.println("ApplicationReadyEvent, ready time: " + event.getTimeTaken().toMillis());
        simpleBean.printInf();
    }
}
