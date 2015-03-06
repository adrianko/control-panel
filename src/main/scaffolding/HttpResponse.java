package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public abstract class HttpResponse implements HttpHandler {
    
    public void handle(HttpExchange t) throws IOException {
        Response.send(t, getResponse(), getCode(), getContentType());
    }
    
    public abstract String getResponse();
    public abstract String getContentType();
    public abstract int getCode();

}