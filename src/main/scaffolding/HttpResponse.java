package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.core.Response;

import static main.core.Helper.log;

public abstract class HttpResponse implements HttpHandler {
    
    public HttpResponse() {
        log("Loading: " + getClass().getName());
    }
    
    public void handle(HttpExchange t) {
        log("Request: " + t.getRequestURI().getPath());
        Response.send(t, this);
    }
    
    public abstract String getResponse();
    public abstract String getContentType();
    public abstract int getCode();

}