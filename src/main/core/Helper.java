package main.core;

import java.util.logging.Logger;

public class Helper {
    
    public static Logger logger = Logger.getLogger(Helper.class.getName());

    public static void log(String s) {
        logger.info(s);
    }
    
}