package com.dnikitin.spring.event.events.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

@Component
public class Chef {

    private final BlockingQueue<String> queue;

    public Chef(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @PostConstruct
    public void prepareChef(){
        new Thread(this::processOrder).start();
    }

    public void processOrder(){
        try{
            while(true){
                String orderDetails = queue.take();
                System.out.println("Order [" +  orderDetails + "] has been taken");

                Thread.sleep(3000);

                System.out.println("Order [" +  orderDetails + "] is ready");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
