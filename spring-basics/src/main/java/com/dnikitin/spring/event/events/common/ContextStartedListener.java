package com.dnikitin.spring.event.events.common;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {


    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Application started. Source " + event.getSource());
    }
}
