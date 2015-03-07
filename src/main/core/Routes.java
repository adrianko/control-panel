package main.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import main.controllers.*;

public class Routes {
    
    private Map<String, HttpHandler> urls = new HashMap<>();
    
    public Routes() {
        urls.put("/404", new Error404());

        try {
            JSONObject paths = (JSONObject) new JSONParser().parse(loadRoutes());

            for (Object key : paths.keySet()) {
                String route = key.toString();
                String controller = paths.get(route).toString();

                urls.put(route, (HttpHandler) Class.forName("main.controllers." + controller).newInstance());
            }
        } catch (ParseException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Map<String, HttpHandler> getRoutes() {
        return urls;
    }

    private String loadRoutes() {
        try {
            return new String(Files.readAllBytes(Paths.get("conf/routes.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
}