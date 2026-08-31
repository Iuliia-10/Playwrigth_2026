package com.demowebshop.api.utils;

public class SessionContext {

    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SessionContext.token = token;
    }

}
