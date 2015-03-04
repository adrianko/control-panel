package main;

import com.sun.net.httpserver.HttpHandler;

import java.util.HashMap;
import java.util.Map;

import main.routes.*;

public class Routes {
    
    public static Map<String, HttpHandler> urls;
    static {
        Map<String, HttpHandler> routes = new HashMap<>();
        routes.put("/", new Home());
        routes.put("/admin", new Admin());
        
        urls = routes;
    }
    
}