package main;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ControlPanel {

    public static void main(String[] args) {
        try {
            Helper.log("Starting server on port 9999");
            HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
            Helper.log("Loading routes");
            Routes.urls.forEach(server::createContext);
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}