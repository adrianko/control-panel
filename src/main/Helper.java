package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String currentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String stamp(String s) {
        return currentTime() + ": " + s;
    }

    public static void log(String s) {
        System.out.println(stamp(s));
    }
    
}