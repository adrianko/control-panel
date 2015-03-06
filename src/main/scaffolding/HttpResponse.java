package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import static main.core.Helper.log;

public abstract class HttpResponse implements HttpHandler {
    
    public HttpResponse() {
        log("Loading: " + getClass().getName());
    }
    
    public void handle(HttpExchange t) throws IOException {
        log("Request: " + t.getRequestURI().getPath());
        Response.send(t, this);
    }
    
    public abstract String getResponse();
    public abstract String getContentType();
    public abstract int getCode();

}