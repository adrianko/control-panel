package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import main.core.Base;
import main.core.Response;
import main.core.Routes;

import java.io.File;

import static main.core.Helper.log;

public class Handler implements HttpHandler {
    
    private Routes routes;
    
    public Handler(Routes r) {
        routes = r;
    }
    
    public void handle(HttpExchange t) {
        log(t.getRequestMethod() + ": " + t.getRequestURI().toString());
        File f = new File(Base.path + t.getRequestURI().toString());

        if (f.exists() && !f.isDirectory()) {
            Response.sendAsset(t, f.getAbsolutePath());
        } else {
            HttpResponse controller = (HttpResponse) routes.getRoutes().get(routes.getRoutes().containsKey(
                    t.getRequestURI().getPath()) ? t.getRequestURI().getPath() : "/404");
            controller.setRequest(t);
            controller.parseRequest();
            Response.send(t, controller);
        }
    }
    
}