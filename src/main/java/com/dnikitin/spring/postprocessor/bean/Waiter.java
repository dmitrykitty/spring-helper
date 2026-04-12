package com.dnikitin.spring.postprocessor.bean;

import org.springframework.stereotype.Component;

@Component
public class Waiter {
    private boolean onDuty;

    public void takeOrder(){
        if(onDuty){
            System.out.println("I'm on Duty. I can take order");
        }else{
            System.out.println("I can't take order");
        }
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }
}
