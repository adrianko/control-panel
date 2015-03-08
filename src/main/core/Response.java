package main.core;

import com.sun.net.httpserver.HttpExchange;
import main.scaffolding.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static void sendAsset(HttpExchange t, String asset) {
        try {
            log("Response: 200 " + asset);
            byte[] file = Files.readAllBytes(Paths.get(asset));
            t.sendResponseHeaders(200, file.length);
            OutputStream os = t.getResponseBody();
            os.write(file);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}