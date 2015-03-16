package main.app.controllers;

import main.scaffolding.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrentIP extends HttpResponse {
    
    String response;
    
    @Override
    public void parseRequest() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL("http://wtfismyip.com/text")
            .openConnection().getInputStream()))) {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       response = content.toString();
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public String getContentType() {
        return "text/plain";
    }

    @Override
    public int getCode() {
        return 200;
    }
    
}