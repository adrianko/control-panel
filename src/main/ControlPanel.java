package main;

import com.sun.net.httpserver.HttpServer;
import main.scaffolding.Handler;

import java.io.IOException;
import java.net.InetSocketAddress;

import static main.Helper.log;

public class ControlPanel {

    public static void main(String[] args) {
        try {
            log("Starting server on port 9999");
            HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
            server.createContext("/", new Handler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}