package main.core;

import com.sun.net.httpserver.HttpExchange;
import main.scaffolding.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static main.core.Helper.log;

public class Response {
    
    public static void send(HttpExchange t, HttpResponse hr) {
        try {
            log("Response: " + hr.getCode() + " " + hr.getContentType() + " " + hr.getClass().getName());
            t.getResponseHeaders().add("Content-Type", hr.getContentType());
            t.sendResponseHeaders(hr.getCode(), hr.getResponse().length());
            send(t.getResponseBody(), hr.getResponse().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendAsset(HttpExchange t, String asset) {
        try {
            log("Response: 200 " + Files.probeContentType(Paths.get(asset)) + " " + t.getRequestURI().toString());
            byte[] file = Files.readAllBytes(Paths.get(asset));
            t.sendResponseHeaders(200, file.length);
            send(t.getResponseBody(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void send(OutputStream os, byte[] response) {
        try {
            os.write(response);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}