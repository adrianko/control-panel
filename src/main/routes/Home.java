package main.routes;

import com.sun.net.httpserver.HttpExchange;
import main.Helper;
import main.Routes;
import main.scaffolding.Response;
import main.scaffolding.HttpResponse;

import java.io.IOException;

public class Home extends HttpResponse {
    
    @Override
    public String getResponse() {
        return "<h1>Hello World</h1>";
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public int getCode() {
        return 200;
    }

    public void handle(HttpExchange t) throws IOException {
        Helper.log("Request: " + t.getRequestURI().getPath());
        
        if (!t.getRequestURI().getPath().equals("/")) {
            Response.send(t, (HttpResponse) Routes.urls.get("/404"));
        } else {
            Response.send(t, this);
        }
    }
    
}