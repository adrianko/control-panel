package main.routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.Response;

import java.io.IOException;

public class Admin implements HttpHandler {

    public static int code = 200;
    public static String response = "<h1>Admin Panel</h1>";
    public static String contentType = "text/html";

    @Override
    public void handle(HttpExchange t) throws IOException {
        Response.send(t, response, code, contentType);
    }

}