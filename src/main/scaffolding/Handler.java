package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import main.Routes;
import static main.core.Helper.log;

public class Handler implements HttpHandler {
    
    public void handle(HttpExchange t) throws IOException {
        log("Request: " + t.getRequestURI().getPath());
        
        if (Routes.getRoutes().containsKey(t.getRequestURI().getPath())) {
            Response.send(t, (HttpResponse) Routes.getRoutes().get(t.getRequestURI().getPath()));
        } else {
            Response.send(t, (HttpResponse) Routes.getRoutes().get("/404"));
        }
    }
    
}