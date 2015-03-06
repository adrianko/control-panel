package main.scaffolding;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

import static main.Helper.log;

public class Response {
    
    public static void send(HttpExchange t, HttpResponse hr) {
        send(t, hr.getResponse(), hr.getCode(), hr.getContentType());
    }
    
    public static void send(HttpExchange t, String response, int responseCode, String contentType) {
        try {
            log("Response: " + responseCode + " " + contentType);
            t.getResponseHeaders().add("Content-Type", contentType);
            t.sendResponseHeaders(responseCode, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
