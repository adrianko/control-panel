package main;

import com.sun.net.httpserver.HttpHandler;

import java.util.HashMap;
import java.util.Map;

import main.controllers.*;

public class Routes {
    
    private Map<String, HttpHandler> urls = new HashMap<>();
    
    public Routes() {
        urls.put("/", new Home());
        urls.put("/admin", new Admin());
        urls.put("/404", new Error404());
    }
    
    public Map<String, HttpHandler> getRoutes() {
        return urls;
    }
    
}