package com.dnikitin.aop.example.utils;

public final class ThreadUtils {
    private ThreadUtils() {}

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(){
        sleep(1000);
    }

}
