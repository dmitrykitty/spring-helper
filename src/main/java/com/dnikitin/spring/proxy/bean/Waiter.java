package com.dnikitin.spring.proxy.bean;

public class Waiter implements IWaiter {
    public String getName() {
        return name;
    }

    private final String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public void serve(String customerName) {
        System.out.println(name + " is serving customer " + customerName);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(name + " is free");
    }
}
