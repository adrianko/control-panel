package main.core;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import main.scaffolding.Handler;

import static main.core.Helper.log;

public class Server {

    private HttpServer server;

    public Server(String nic, int port) {
        try {
            log("Starting server on port " + port);
            server = HttpServer.create(new InetSocketAddress(InetAddress.getByName(nic), port), 0);

            // push all requests through handler
            server.createContext("/", new Handler(new Routes()));
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        server.stop(0);
    }

}