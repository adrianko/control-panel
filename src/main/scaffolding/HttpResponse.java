package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.Helper;

import java.io.IOException;

public abstract class HttpResponse implements HttpHandler {
    
    public HttpResponse() {
        Helper.log("Loading: " + getClass().getName());
    }
    
    public void handle(HttpExchange t) throws IOException {
        Response.send(t, this);
    }
    
    public abstract String getResponse();
    public abstract String getContentType();
    public abstract int getCode();

}