package main.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Helper {
    
    public static Logger logger = Logger.getLogger(Helper.class.getName());

    public static String currentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String stamp(String s) {
        return currentTime() + ": " + s;
    }

    public static void log(String s) {
        logger.info(s);
    }
    
}