package main.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import main.app.controllers.*;

public class Routes {
    
    private Map<String, HttpHandler> urls = new HashMap<>();
    
    public Routes() {
        defaultRoutes();

        try {
            JSONObject paths = (JSONObject) new JSONParser().parse(loadRoutes());

            for (Object key : paths.keySet()) {
                String route = key.toString();
                String controller = paths.get(route).toString();

                urls.put(route, (HttpHandler) Class.forName("main.app.controllers." + controller).newInstance());
            }
        } catch (ParseException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Map<String, HttpHandler> getRoutes() {
        return urls;
    }

    private void defaultRoutes() {
        urls.put("/404", new Error404());
    }

    private String loadRoutes() {
        try {
            //return new String(Files.readAllBytes(Paths.get("conf/routes.json")));
            return new String(Files.readAllBytes(Paths.get(new File(this.getClass().getResource(".").getPath() +
                    "../../../../../conf/routes.json").getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
}