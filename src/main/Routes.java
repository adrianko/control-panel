package main;

import com.sun.net.httpserver.HttpHandler;

import java.util.HashMap;
import java.util.Map;

import main.routes.*;

public class Routes {
    
    private static Map<String, HttpHandler> urls;
    static {
        Map<String, HttpHandler> routes = new HashMap<>();
        routes.put("/", new Home());
        routes.put("/admin", new Admin());
        routes.put("/404", new Error404());
        
        urls = routes;
    }
    
    public static Map<String, HttpHandler> getRoutes() {
        return urls;
    }
    
}