package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

import static main.core.Helper.log;

public class Response {
    
    public static void send(HttpExchange t, HttpResponse hr) {
        try {
            log("Response: " + hr.getClass().getName() + " " + hr.getCode() + " " + hr.getContentType());
            t.getResponseHeaders().add("Content-Type", hr.getContentType());
            t.sendResponseHeaders(hr.getCode(), hr.getResponse().length());
            OutputStream os = t.getResponseBody();
            os.write(hr.getResponse().getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}