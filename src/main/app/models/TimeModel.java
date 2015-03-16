package main.app.models;

public class TimeModel {
    
    public static String since(int timestamp) {
        return String.valueOf(System.currentTimeMillis() - timestamp);    
    }
    
}
