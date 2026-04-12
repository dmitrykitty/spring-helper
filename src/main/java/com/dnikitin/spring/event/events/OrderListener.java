package com.dnikitin.spring.event.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

@Component
public class OrderListener {

    private final BlockingQueue<String> queue;

    public OrderListener(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @EventListener(OrderEvent.class)
    public void onOrderEvent(OrderEvent event) {
        String orderDetails = event.getOrderDetails();
        try {
            queue.put(orderDetails);
            System.out.println("Order received: " + orderDetails);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
