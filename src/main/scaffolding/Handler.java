package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.Routes;

import java.io.IOException;

import static main.Helper.log;

public class Handler implements HttpHandler {
    
    public void handle(HttpExchange t) throws IOException {
        log("Request: " + t.getRequestURI().getPath());
        
        if (Routes.urls.containsKey(t.getRequestURI().getPath())) {
            Response.send(t, (HttpResponse) Routes.urls.get(t.getRequestURI().getPath()));
        } else {
            Response.send(t, (HttpResponse) Routes.urls.get("/404"));
        }
    }
    
}
