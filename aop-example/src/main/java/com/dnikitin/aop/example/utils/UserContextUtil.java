package com.dnikitin.aop.example.utils;

public final class UserContextUtil {

    private static final ThreadLocal<String> USERNAME = new  ThreadLocal<>();

    private UserContextUtil() {}

    public static String getUsername() {
        return USERNAME.get();
    }
    public static void setUsername(String username) {
        USERNAME.set(username);
    }


}
