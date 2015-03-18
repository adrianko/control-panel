package main.app.controllers;

import main.scaffolding.HttpResponse;

public class CurrentIP extends HttpResponse {
    
    String response;
    
    @Override
    public void parseRequest() {
        
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