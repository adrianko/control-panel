package main.app.controllers;

import main.scaffolding.HttpResponse;

import main.app.models.*;

public class Admin extends HttpResponse {
    
    String response;

    @Override
    public void parseRequest() {
        response = TimeModel.since(1234567890);
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public int getCode() {
        return 200;
    }
    
}